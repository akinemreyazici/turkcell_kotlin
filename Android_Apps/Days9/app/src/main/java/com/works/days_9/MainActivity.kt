package com.works.days_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import com.works.days_9.models.Currency

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        // Thread {
            // xml.xmlCatalog()
        //}.start()

        val xml = XmlResult()
        val arr = xml.xmlCatalog()
        for (item in arr)
        {
            //Log.d("item",item.COMMON)
        }

        val currency = XmlResult()
        val arr2 = currency.xmlCurrency()
        for (item in arr2)
        {
            Log.d("item",item.Unit)
            Log.d("item",item.Isim)
            Log.d("item",item.CurrencyName)
            Log.d("item",item.ForexBuying)
            Log.d("item",item.ForexSelling)
        }


    }
}