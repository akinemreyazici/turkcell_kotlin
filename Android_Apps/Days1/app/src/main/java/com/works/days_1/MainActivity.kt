package com.works.days_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnGotoSettings : Button
    lateinit var txtData : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtData = findViewById(R.id.txtData)
        btnGotoSettings = findViewById(R.id.btnGotoSettings)

        btnGotoSettings.setOnClickListener {
            var data = txtData.text.toString()
            Toast.makeText(this,data,Toast.LENGTH_LONG).show()
        }
    }

}