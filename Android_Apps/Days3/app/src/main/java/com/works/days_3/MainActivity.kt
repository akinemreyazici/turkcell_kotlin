package com.works.days_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    companion object{
        var user = UserData("Serkan","Bilsin","serkanbilsin@mail.com",150)
        var user2 = UserData("Serkan","Bilsin","serkanbilsin@mail.com",150)
    // Nesne olduğundan dolayı statik obje kullanarak bir sonraki activity e aktarırız.
    }

    lateinit var btnGotoProfile : Button
    lateinit var editTextName : EditText
    lateinit var editTextSurname : EditText
    lateinit var editTextMail : EditText
    lateinit var editTextID : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGotoProfile = findViewById(R.id.btnGotoProfile)
        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        editTextMail = findViewById(R.id.editTextMail)
        editTextID = findViewById(R.id.editTextID)

        btnGotoProfile.setOnClickListener {
            var intent = Intent(this, Profile::class.java) // hangi activityden , hangi activitye geçeceğimizi burada belirtiriz.
            intent.putExtra("name",editTextName.text.toString())
            intent.putExtra("surname",editTextSurname.text.toString()) // Bir sonraki sayfaya veri aktarmamıza sağlar keyword ile birlikte
            intent.putExtra("mail",editTextMail.text.toString())
            intent.putExtra("id",editTextID.text.toString())

            MainActivity.user = UserData("Serkan","Bilsin","serkanbilsin@mail.com",150)
            user2 = UserData(editTextName.text.toString(),editTextSurname.text.toString(),editTextMail.text.toString(),editTextID.text.toString().toInt())

            startActivity(intent)
            // finish()  Bu sınıfı öldürmüş oluruz geri dönmek istediğimizde activity mizi bulamayacağız.
        }
    }
}