package com.works.days_11

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.works.days_11.configs.ApiClient
import com.works.days_11.configs.Util
import com.works.days_11.models.JWTData
import com.works.days_11.models.JWTUser
import com.works.days_11.services.DummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var editTxtUsername: EditText
    lateinit var editTxtPassword: EditText
    lateinit var btnSend: Button
    lateinit var dummyService: DummyService

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE)
        editor = sharedPreferences.edit()

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        editTxtUsername = findViewById(R.id.editTxtUsername)
        editTxtPassword = findViewById(R.id.editTxtPassword)
        btnSend = findViewById(R.id.btnSend)


        btnSend.setOnClickListener(btnClick)

        val userName = sharedPreferences.getString("userName","")
        editTxtUsername.setText(userName)


    }

    val btnClick = View.OnClickListener {
        val username = editTxtUsername.text.toString()
        val password = editTxtPassword.text.toString()
        val jwtUser = JWTUser(username, password)
        dummyService.login(jwtUser).enqueue(object : Callback<JWTData> {
            override fun onResponse(call: Call<JWTData>, response: Response<JWTData>) {
                val jwtUser = response.body()
                Log.d(
                    "status",
                    response.code().toString()
                ) // HTTP Status code , 200 ise yukarıdaki işlemi başarıyla tamamladı bir hataya düşmedi fakat değerin içeriğini bize vermez. 200 den başka hatalar 403 path'ında sorun olabileceğini,400  password username yanlış olabileceği hakkında bilgiler verir
                if (jwtUser != null) {
                    Util.user = jwtUser
                    Log.d("jwtUser", jwtUser.toString())

                    editor.putString("userName", jwtUser.username)
                    editor.putString("firstName",jwtUser.firstName)
                    editor.commit()

                    val intent = Intent(this@MainActivity, Products::class.java)
                    startActivity(intent)
                    finish()
                }
            }

            override fun onFailure(call: Call<JWTData>, t: Throwable) {
                Log.e("Login", t.toString())
                Toast.makeText(this@MainActivity, "Internet or Server Fail", Toast.LENGTH_LONG)
                    .show()
            }

        })

    }
}