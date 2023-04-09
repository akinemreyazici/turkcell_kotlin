package com.works.odev_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ResultActivity : AppCompatActivity() {

    lateinit var ListViewData1 : ListView
    lateinit var ListViewData2 : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        ListViewData1 = findViewById(R.id.ListViewData1)
        ListViewData2 = findViewById(R.id.ListViewData2)

        var adapter1 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.arr1)
        ListViewData1.adapter = adapter1

        var adapter2 = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.arr2)
        ListViewData2.adapter = adapter2

        /*
            ListView vb. türleri kullanmak için Adapter kullanıyoruz. Burada derste de kullandığımız
         tek satırlı-verili simple_list_item1'i kullandım listelerdeki verilerimide MainActivity'de
         kullandığım companion object sayesinde çağırabildim.

         */

    }
}