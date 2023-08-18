package com.khantnyar.recyclerview.view.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.khantnyar.recyclerview.R
import com.khantnyar.recyclerview.adapter.CustomerAdapter
import com.khantnyar.recyclerview.databinding.ActivityCustomerBinding
import com.khantnyar.recyclerview.models.CustomerApiResponse
import com.khantnyar.recyclerview.models.Customers
import com.khantnyar.recyclerview.models.OrderApiResponse
import com.khantnyar.recyclerview.utils.DateAndTimeUtil
import com.khantnyar.recyclerview.utils.OdooApiClient
import com.khantnyar.recyclerview.utils.UserAndDateReference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerBinding
    private lateinit var customerAdapter: CustomerAdapter

    private var customers: MutableList<Customers> = mutableListOf()
    private var customersHasOrder: MutableList<Customers> = mutableListOf()

    private lateinit var user: AppCompatTextView
    private lateinit var tvmenu: AppCompatTextView

//    private lateinit var customersWithOrders: MutableList<Customers>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_customer)
        setContentView(binding.root)
        initializeViews()
    }

    private fun initializeViews() {
        /*
        * init the variable that we will use in onCreate function
        * eg :  private lateinit var user: AppCompatTextView
        *       user findViewById(R.id.tv_user_name)
        * */
        user = findViewById(R.id.tv_user_name)
        tvmenu = findViewById(R.id.tv_date_menu)

        customerAdapter = CustomerAdapter(customers)
        binding.rvCustomerList.apply {
            layoutManager = LinearLayoutManager(this@CustomerActivity)
            adapter = customerAdapter
        }
        binding.btnBeforeRing.apply {
            text = getString(R.string.to_call) + "( ${customers.size} )"
            setColorsAndDrawable(this, true)
            setOnClickListener { switchBtn(this) }
        }
        binding.btnAfterRing.apply {
            text = getString(R.string.ordered) + "( ${customersHasOrder.size} )"
            setColorsAndDrawable(this, false)
            setOnClickListener { switchBtn(this) }
            getAllCustomers("to invoice")
        }
        navbar()
        setupDateMenu()

        getAllCustomers()
    }

    private fun getAllCustomers(invoiceStatus:String? = "") {
        val todayDate = DateAndTimeUtil.getCurrentDayOfWeek()
        val fields = "['name','display_name','active','email','phone','customer_status','debit_limit','employee_ids','user_id','owner_name','sale_order_ids']"
        val domain = "[('customer_status','=','Active'),('name', 'not ilike', 'copy'),('day','=','$todayDate')]"//$todayDate //('customer_status','=','Active'),
        val order = "name asc"
        val call: Call<CustomerApiResponse> = OdooApiClient.apiService.getAllCustomer("res.partner", fields,  0, order, domain)

        call.enqueue(object : Callback<CustomerApiResponse> {
            override fun onResponse(
                call: Call<CustomerApiResponse>,
                response: Response<CustomerApiResponse>
            ) {
                try {
                    val listOfData = response.body()?.customers
                    if (response.isSuccessful && response.body()?.success == true) {
                        var responseData = listOfData ?: emptyList()
                        if (responseData.isNotEmpty() && listOfData != null) {
                            customers.addAll(responseData)
                            for (data in responseData){
                                getOrdered(invoiceStatus,data,listOfData)
                            }
                        }
                    } else {
                        showError("Failed to Fetch Customer")
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                    showError("Error: ${ex.message}")
                }
            }

            override fun onFailure(call: Call<CustomerApiResponse>, t: Throwable) {
                showError("Error: ${t.message}")
            }
        })
    }

    private fun getOrdered(
        invoiceStatus: String?,
        data: Customers,
        listOfCustomer: List<Customers>
    ){
        val saleOrderIds = data.sale_order_ids?.mapNotNull { it?.id } ?: emptyList()
        val orderFields = "['id', 'name', 'invoice_status','partner_id']"
        val orderDomain:String = if (invoiceStatus == "to invoice"){
            "[('id','in',${saleOrderIds}),('invoice_status','=',$invoiceStatus)]"
        }else{
            ""
        }
        val orderCall: Call<OrderApiResponse> = OdooApiClient.apiService.getAllOrder(domain = orderDomain, fields = orderFields)

        orderCall.enqueue(object : Callback<OrderApiResponse> {
            override fun onResponse(
                call: Call<OrderApiResponse>,
                response: Response<OrderApiResponse>
            ) {
                try {
                    var listOfCustomer = listOfCustomer
                    var listOfData = response.body()?.orders
                    if (response.isSuccessful && response.body()?.success == true) {
                        var responseData = listOfData ?: emptyList()
                        if (responseData != null){
                            val orderHaveCustomer = responseData.filter { order -> order.invoice_status == "to invoice" }
                            Log.d("whoHaveOrder", "whoHaveOrder: $orderHaveCustomer")
                            customerAdapter.updateData(listOfCustomer ,saleOrderIds)
                        }
                    }
                    // get who have order

                } catch (ex:Exception){
                    ex.printStackTrace()
                    showError("Error: ${ex.message}")
                }
            }

            override fun onFailure(call: Call<OrderApiResponse>, t: Throwable) {
                showError("Error: ${t.message}")
            }
        })
    }

    private fun setColorsAndDrawable(button: Button, isSelected: Boolean) {
        val selectedColor = Color.WHITE
        val unselectedColor = Color.BLACK
        val selectedDrawable = R.drawable.selected_btn
        val unselectedDrawable = R.drawable.unselected_btn

        button.setTextColor(if (isSelected) selectedColor else unselectedColor)
        button.setBackgroundDrawable(ContextCompat.getDrawable(this, if (isSelected) selectedDrawable else unselectedDrawable))
    }

    private fun switchBtn(button: Button) {
        if (button == binding.btnBeforeRing) {
            setColorsAndDrawable(binding.btnBeforeRing, true)
            setColorsAndDrawable(binding.btnAfterRing, false)
        } else if (button == binding.btnAfterRing) {
            setColorsAndDrawable(binding.btnAfterRing, true)
            setColorsAndDrawable(binding.btnBeforeRing, false)
        }
    }
    private fun navbar () {
        user.text = UserAndDateReference.getUserName(this);
        val appDataDate = arrayOf("Mon pickup", "Tue delivery", "Wed delivery", "Thu delivery", "Fri delivery")
        val selectedDate = UserAndDateReference.getSelectedDate(this)
        if (selectedDate == null)
        {
            tvmenu.text = UserAndDateReference.getTodayDateOption();
        } else {
            tvmenu.text = selectedDate;
        }

        tvmenu.setOnClickListener {
            UserAndDateReference.showDatePopup(this, tvmenu, appDataDate) { itemId ->
                val selectedDay = UserAndDateReference.storeSelectedDate(appDataDate[itemId], this);
                tvmenu.text = selectedDay
            }
        }
    }

    private fun setupDateMenu() {
        tvmenu.text = UserAndDateReference.getSelectedDate(this) ?: UserAndDateReference.getTodayDateOption()
        tvmenu.setOnClickListener {
            val appDataDate = arrayOf("Mon pickup", "Tue delivery", "Wed delivery", "Thu delivery", "Fri delivery")
            UserAndDateReference.showDatePopup(this, tvmenu, appDataDate) { itemId ->
                val selectedDay = UserAndDateReference.storeSelectedDate(appDataDate[itemId], this)
                tvmenu.text = selectedDay
            }
        }
    }
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    private fun updateRecyclerView(data: List<Customers>) {
        customerAdapter.updateData(data, emptyList())
    }
}