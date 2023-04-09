package com.works.odev_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var bttnData1 : Button
    lateinit var bttnData2 : Button
    lateinit var bttnResult : Button
    lateinit var txtData1 : EditText
    lateinit var txtData2 : EditText


    companion object{
        var arr1 = mutableListOf<String>()
        var arr2 = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bttnData1 = findViewById(R.id.bttnData1)
        bttnData2 = findViewById(R.id.bttnData2)
        bttnResult = findViewById(R.id.bttnResult)
        txtData1 = findViewById(R.id.txtData1)
        txtData2 = findViewById(R.id.txtData2)



        bttnData1.setOnClickListener {
            arr1.add("${arr1.size}) ${txtData1.text.toString()}")
            txtData1.setText("")
            txtData1.requestFocus()
           // Log.d("info1",arr1.get(0))

        }

        bttnData2.setOnClickListener {
            arr2.add("${arr2.size}) ${txtData2.text.toString()}")
            txtData2.setText("")
            txtData2.requestFocus()

            //  Log.d("info2",arr2.get(0))
        }

        bttnResult.setOnClickListener {
            var intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
    }
}