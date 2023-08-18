package com.khantnyar.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khantnyar.recyclerview.R
import com.khantnyar.recyclerview.models.Customers

class CustomerAdapter(
    private var data: List<Customers>,
    private var showUnchecked: Boolean = true
):RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        view.isEnabled = parent.isEnabled
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = data[position]
        val order = customer.sale_order_ids?.mapNotNull { it?.id } ?: emptyList()
        holder.bind(customer,order,showUnchecked)
    }

    fun updateData(newData: List<Customers>, saleOrderIds: List<Int>) {
        data = newData
        notifyDataSetChanged()
    }
    fun setShowUnchecked(show: Boolean) {
        showUnchecked = show
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class CustomerViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val displayNameTextView: TextView = itemView.findViewById(R.id.tvId)
        private val ownerNameTextView: TextView = itemView.findViewById(R.id.tvOwnerName)
        private val orderCheckBox: CheckBox = itemView.findViewById(R.id.tvOrderChecked)

        fun bind(customers: Customers, orders: List<Int>, show: Boolean){
            displayNameTextView.text=customers.display_name
            ownerNameTextView.text=customers.owner_name
            val saleOrderIds = customers.sale_order_ids?.map { it?.id }
            val hasDesiredOrder = saleOrderIds?.any { it in orders } ?: false
            orderCheckBox.isChecked = hasDesiredOrder
            if(show){
                val saleOrderIds = customers.sale_order_ids?.map { it?.id }
                val hasDesiredOrder = saleOrderIds?.any { it in orders } ?: false
                orderCheckBox.isChecked = hasDesiredOrder
                orderCheckBox.visibility = View.VISIBLE
            }else{
                orderCheckBox.visibility = View.GONE

            }
        }
    }
}