package com.works.days_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var btnGotoSettings : Button
    lateinit var txtData : EditText
    lateinit var txtViewData : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtData = findViewById(R.id.txtData)
        btnGotoSettings = findViewById(R.id.btnGotoSettings)
        txtViewData = findViewById(R.id.txtViewData)

        var btnColor = btnGotoSettings.backgroundTintList?.defaultColor

        btnGotoSettings.setOnClickListener {
            var data = txtData.text.toString()
            Toast.makeText(this,data,Toast.LENGTH_LONG).show()
        }

        // OnChange
        txtData.addTextChangedListener {

            txtViewData.text = it.toString()
            if(it.toString() == "zehra@mail.com")
            {
                btnGotoSettings.setBackgroundColor(Color.RED)
            }
            else
            {
                btnGotoSettings.setBackgroundColor(btnColor!!)
            }
        }



    }
    /*
    fun bttnClick(view : View) : Unit {
        view.setBackgroundColor(Color.RED)
        var btn: Button = view as Button
        var title = btn.text
        Log.i("",title.toString())
        var data = txtData.text.toString()
        Toast.makeText(this,"bttnClick : " +data,Toast.LENGTH_LONG).show()
    }
     */
}

