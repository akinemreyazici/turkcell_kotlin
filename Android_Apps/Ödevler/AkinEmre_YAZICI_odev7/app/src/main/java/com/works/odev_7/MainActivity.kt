package com.works.odev_7

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.works.odev_7.adapter.NoteListAdapter
import com.works.odev_7.models.Notes
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var txtTitle: EditText
    lateinit var txtDetail: EditText
    lateinit var btnDate: Button
    lateinit var btnSave: Button
    lateinit var listNotes : ListView

    lateinit var db: DB

    var selectedDate = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTitle = findViewById(R.id.txtTitle)
        txtDetail = findViewById(R.id.txtDetail)
        btnDate = findViewById(R.id.btnDate)
        btnSave = findViewById(R.id.btnSave)
        listNotes = findViewById(R.id.listNotes)



        db = DB(this)


        val calendar = Calendar.getInstance() // Bugünkü tarihi alıyoruz

        btnDate.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    //Log.d("i/year", i.toString())
                    //Log.d("i2/month", (i2 + 1).toString())
                    //Log.d("i3/day", i3.toString())
                    var ay = "${i2 + 1}"
                    if (i2 + 1 < 10) {
                        ay = "0" + ay
                    }
                    selectedDate = "$i3.$ay.$i"

                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }
        btnSave.setOnClickListener {
            val title = txtTitle.text.toString()
            val detail = txtDetail.text.toString()
            if (selectedDate != "" && title != "" && detail != "")
            {
                var status = db.addNote(title,detail,selectedDate)
                //Log.d("Status",status.toString())
                val allNotes = db.showNotes()
                //Log.d("All Notes",allNotes.toString())
            }
            else
            {
                Toast.makeText(this,"Lütfen alanları eksiksiz doldurdun",Toast.LENGTH_LONG).show()
            }
        }

        val customAdapter = NoteListAdapter(this,db.showNotes())
        listNotes.adapter = customAdapter

        listNotes.setOnItemClickListener { adapterView, view, i, l ->
            val selectedNote = listNotes.getItemAtPosition(i) as Notes
            val intent = Intent(this,NoteDetailActivity::class.java)
            intent.putExtra("Title",selectedNote.Title)
            intent.putExtra("Detail",selectedNote.Detail)
            intent.putExtra("Date",selectedNote.Date)
            intent.putExtra("NID",selectedNote.NID)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        val customNewAdapter = NoteListAdapter(this,db.showNotes())
        listNotes.adapter = customNewAdapter

    }
    /* Android Lifecycle'da onResume iken uygulama foreground'da kaldığında tekrar geri dönüldüğünde uygulanan
      kodlar çalışıyor yani adapter'ımızı günceller isek database'den notlar güncellenmiş olur. */
}