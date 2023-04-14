package com.works.days_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var btnAlert : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlert = findViewById(R.id.btnAlert)

        var arr = resources.getStringArray(R.array.cities) // Xml'de kaydettiğimiz diziyi mainde çağırdık
        for (item in arr)
        {
            Log.d("item",item)
        }

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Alert Title")
    }
}