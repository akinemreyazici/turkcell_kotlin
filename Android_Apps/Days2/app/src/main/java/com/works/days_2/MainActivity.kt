package com.works.days_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var btnToast : Button
    lateinit var customToastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToast = findViewById(R.id.btnToast)
      //  txtToastInformation = findViewById(R.id.txtToastInformation)

        btnToast.setOnClickListener(btnToastClickListener)

       // customToastView = layoutInflater.inflate(R.layout.custom_toast,null)
       // customToastView.findViewById<ViewGroup>(R.id.customToastID)

       // var toast = Toast.makeText(this,"Toast Title",Toast.LENGTH_SHORT)
       // toast.setGravity(Gravity.LEFT,200,200)
       // toast.show()
    }

    val btnToastClickListener = View.OnClickListener {
       // Toast.makeText(this,"Bttn Toast",Toast.LENGTH_LONG).show()
        /*

        var toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_LONG
        toast.view = customToastView
        toast.show()

        */

        var toast = CustomToast(this,"Selam").createToast()
        toast.show()
    }


}