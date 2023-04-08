package com.works.days_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Profile : AppCompatActivity() {
    lateinit var textViewName : TextView
    lateinit var textViewSurname : TextView
    lateinit var textViewMail : TextView
    lateinit var textViewID : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        textViewName = findViewById(R.id.textViewName)
        textViewSurname = findViewById(R.id.textViewSurname)
        textViewMail = findViewById(R.id.textViewMail)
        textViewID = findViewById(R.id.textViewID)

        textViewName.text = intent.getStringExtra("name")
        textViewSurname.text = intent.getStringExtra("surname")
        textViewMail.text = intent.getStringExtra("mail")
        textViewID.text = intent.getStringExtra("id")

        // textViewName.text = MainActivity.user2.name companion object kullanarak da böyle yapabiliriz.


        //var name = intent.getStringExtra("name")
        //var id = intent.getIntExtra("id",0)  Bir önceki intentte gönderilen verileri yakalamamızı sağlar.
        /*
        if (name != null)
        {
            Log.d("name",name)
            Log.d("id",id.toString())
        }

        Log.d("user",MainActivity.user.toString())
        */

    }
}