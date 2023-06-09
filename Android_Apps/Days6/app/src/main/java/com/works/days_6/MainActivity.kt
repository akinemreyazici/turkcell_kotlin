package com.works.days_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.works.days_6.adapter.UserCustomAdapter
import com.works.days_6.services.UserService
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {

    lateinit var listView : ListView
    val userService = UserService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.userListView)
        val customAdapter = UserCustomAdapter(this,userService.userResult())
        listView.adapter = customAdapter

    }
}