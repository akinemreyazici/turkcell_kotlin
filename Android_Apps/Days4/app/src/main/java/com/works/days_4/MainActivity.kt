package com.works.days_4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.util.UUID

class MainActivity : AppCompatActivity() {

    lateinit var bttnData : Button
    lateinit var txtData : EditText
    lateinit var cityListView : ListView
    var arr = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataResult()

        bttnData = findViewById(R.id.bttnData)
        txtData = findViewById(R.id.txtData)
        cityListView = findViewById(R.id.cityListView)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr)
        cityListView.adapter = adapter
        // adapter.notifyDataSetChanged() // Diziye eklenen yeni bir değer sonrası adapterin refreshlenmesini sağlayan method

        bttnData.setOnClickListener {
            arr.add(txtData.text.toString())
            adapter.notifyDataSetChanged()
            txtData.setText("")
            txtData.requestFocus() // İmleci bu alana getir
        }

        //  Click
        cityListView.setOnItemClickListener { adapterView, view, i, l ->
            Log.d("click", i.toString())
            var intent = Intent(this,Detail::class.java)
            intent.putExtra("data",arr.get(i))
            startActivity(intent)

        }

        // Long Click
        cityListView.setOnItemLongClickListener { adapterView, view, i, l -> // i int indexi , l long indexi anlamına geliyo eğer max int değerine geçersen kullanman için
            if (i == 5) {
                false

            }
            else {
                //arr.removeAt(i) // i ve l pozisyonları belirtiyor
                var item = arr.get(i)
                Log.d("item", item)
                adapter.notifyDataSetChanged()
                view.setBackgroundColor(Color.RED)
                true// Diğerinden farklı olarak true ve false döndürüyoruz istediğimiz zaman uzun basabilmek için
            }
        }

    }


    fun dataResult()
    {
        for (item in 0..20)
        {

            arr.add("Title - ${UUID.randomUUID()}") // Random değer almak için kullandığımız bir method
        }
    }
}