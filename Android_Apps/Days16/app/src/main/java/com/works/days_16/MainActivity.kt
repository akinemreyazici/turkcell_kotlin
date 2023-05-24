package com.works.days_16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)

        val one = One()
        one.arguments?.putString("param1","data1")
        changeFragment(one)
        button1.setOnClickListener{
            one.arguments?.putString("param1","data1")
            changeFragment(one)
        }
        button2.setOnClickListener{
            val two = Two()
            changeFragment(two)
        }
        button3.setOnClickListener{
            val three = Three()
            changeFragment(three)
        }
    }


    fun changeFragment (fragment : Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction() // Sayfanın içinde görsel bir değişim var bana bir nesne kur demektir
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}