package com.works.days_13

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.sql.Date
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var db : DB // database
    lateinit var btnDate : Button
    lateinit var btnSave : Button
    var selectDate = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDate = findViewById(R.id.btnDate)
        btnSave = findViewById(R.id.btnSave)



        db = DB(this)
        //val deleteStatus = db.deleteNote(2)
        //Log.d("deleteStatus",deleteStatus.toString())

        //val updateStatus = db.updateNote(3,"Kahvaltı Notu","Pazar Günü Van Kahvaltısı")
        //Log.d("updateStatus",updateStatus.toString())



        val calendar = Calendar.getInstance() // Bugünkü tarihi alırız.

        btnDate.setOnClickListener(View.OnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    Log.d("i/year",i.toString()) // yıl
                    Log.d("i2/month",(i2 + 1).toString()) // ay
                    Log.d("i3/day",i3.toString()) // gün
                    var ay = "${i2 + 1}"
                    if (i2 + 1 < 10)
                    {
                        ay = "0${i2+1}"
                    }

                    selectDate = "$i3.$ay.$i"
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
            datePickerDialog.show()
        })

        btnSave.setOnClickListener {
            if (selectDate != "") {
                var status = db.addNote("Tarih Notu", "Tarih Detay", selectDate)
                Log.d("Status", status.toString())
                selectDate = ""
                val ls = db.allNote()
                Log.d("ls",ls.toString())
            }else
            {
                Toast.makeText(this,"Please Select Date", Toast.LENGTH_LONG).show()
            }

        }





    }


}