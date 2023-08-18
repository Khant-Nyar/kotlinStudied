package com.khantnyar.recyclerview.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.icu.util.Calendar
import android.util.Base64
import android.view.Menu
import android.view.View
import android.widget.PopupMenu
import com.google.gson.GsonBuilder
import com.khantnyar.recyclerview.services.ApiServiceInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayInputStream
import java.util.concurrent.TimeUnit

object appUtils {
}

object OdooApiClient {
    private const val BASE_URL = Config.BASE_URL
    private const val API_KEY = Config.API_KEY

    // Create Logger
    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    // Create a Custom Interceptor to apply Headers application-wide
    private val headerInterceptor = Interceptor { chain ->
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("api_key", API_KEY)
            .build()
        chain.proceed(request)
    }


    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()
        .callTimeout(0, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)
        .build()

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val apiService: ApiServiceInterface = retrofit.create(ApiServiceInterface::class.java)
}
object StringUtils {
    fun base64toImage(str: String?): Bitmap? {
        val imageBytes = Base64.decode(str, Base64.DEFAULT)
        return BitmapFactory.decodeStream(ByteArrayInputStream(imageBytes))
    }
}
object UserAndDateReference {
    // Reference function to get the user name from SharedPreferences
    fun getUserName(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("LoginPreference", Context.MODE_PRIVATE)
        return sharedPreferences.getString("user_name", null)
    }

    // Reference function to get today's date option
    fun getTodayDateOption(): String {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        val daysOfWeek = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val appDataDate = arrayOf("Mon pickup", "Tue delivery", "Wed delivery", "Thu delivery", "Fri delivery")

        return when (daysOfWeek[dayOfWeek - 1]) {
            "Monday", "Friday", "Saturday", "Sunday" -> appDataDate[0]
            "Tuesday" -> appDataDate[2]
            "Wednesday" -> appDataDate[3]
            "Thursday" -> appDataDate[4]
            else -> ""
        }
    }

    // Reference function to show a date popup menu
    fun showDatePopup(context: Context, anchorView: View, items: Array<String>, onItemClickListener: (Int) -> Unit) {
        val popupMenu = PopupMenu(context, anchorView)
        for (i in items.indices) {
            popupMenu.menu.add(Menu.NONE, i, Menu.NONE, items[i])
        }

        popupMenu.setOnMenuItemClickListener { menuItem ->
            val itemId = menuItem.itemId
            onItemClickListener(itemId)
            true
        }

        popupMenu.show()
    }

    fun storeSelectedDate (selectedDate: String?, context: Context) : String? {
        val sharedPreference =  context.getSharedPreferences("SelectedDateReference", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("selectedDate", selectedDate)
        editor.apply()
        return selectedDate
    }

    fun storeLayoutDisable (condition: Boolean, context: Context) {
        val sharedPreference =  context.getSharedPreferences("DisableLayout", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putBoolean("disable", condition)
        editor.apply()
    }

    fun getDisableLayout (context: Context) : String? {
        val sharedPreferences = context.getSharedPreferences("DisableLayout", Context.MODE_PRIVATE)
        return sharedPreferences.getString("disable", null)
    }

    fun getSelectedDate (context: Context) : String? {
        val sharedPreferences = context.getSharedPreferences("SelectedDateReference", Context.MODE_PRIVATE)
        return sharedPreferences.getString("selectedDate", null)
    }

    fun getCustomer (context: Context) : String? {
        val sharedPreferences = context.getSharedPreferences("CustomerReference", Context.MODE_PRIVATE)
        return sharedPreferences.getString("customer", null)
    }
}

object DateAndTimeUtil {
    fun getCurrentDayOfWeek(): String {
        val calendar = Calendar.getInstance()

        return when (calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.SUNDAY -> "Sun"
            Calendar.MONDAY -> "Mon"
            Calendar.TUESDAY -> "Tue"
            Calendar.WEDNESDAY -> "Wed"
            Calendar.THURSDAY -> "Thu"
            Calendar.FRIDAY -> "Fri"
            Calendar.SATURDAY -> "Sat"
            else -> throw IllegalArgumentException("Invalid day of week")
        }
    }
}
