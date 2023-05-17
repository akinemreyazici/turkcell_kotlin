package com.works.odev_7

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class NoteDetailActivity : AppCompatActivity() {
    lateinit var btnDelete : Button
    lateinit var txtDetailTitle : TextView
    lateinit var txtDetailDetail : TextView
    lateinit var txtDetailDate : TextView
    lateinit var db : DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        btnDelete = findViewById(R.id.btnDelete)
        txtDetailTitle = findViewById(R.id.txtDetailTitle)
        txtDetailDetail = findViewById(R.id.txtDetailDetail)
        txtDetailDate = findViewById(R.id.txtDetailDate)

        db = DB(applicationContext)

        txtDetailTitle.text =  intent.getStringExtra("Title")
        txtDetailDetail.text = "  " + intent.getStringExtra("Detail")
        txtDetailDate.text = "Tarih : " + intent.getStringExtra("Date") + "     "
        val NID = intent.getIntExtra("NID",0)

        btnDelete.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setMessage("Are you sure you wanna delete this note?")
            alert.setCancelable(false) // Bir yere tıklanıldığında iptal edilmesini önledim
            alert.setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->
                Log.d("Cancel","Silmekten vazgeçildi")
            })
            alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                val status = db.deleteNote(NID)
                Log.d("status",status.toString())
                finish()
            })
            alert.show()
        // Notu sildikten sonra bu activity'de işimiz olmadığından sonlandırıyorum onResume tetikleniyor MainActivityde
        }


    }

}