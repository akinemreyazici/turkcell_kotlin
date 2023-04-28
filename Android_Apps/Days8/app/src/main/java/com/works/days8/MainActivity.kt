package com.works.days8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.works.days8.Result

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = Result()
        val run = Runnable {
            val list = result.news()
            Log.d("title",list.get(0).title)
        }
        // Uzun süren kodu thread in içine alarak kod satırı serbest hale getirdik aşağıdaki "Line Call" önce çalıştı
        Thread(run).start()

        // Log.d("Line","This Line Call")
    }
}