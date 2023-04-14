package com.works.days_5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var btnAlert : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAlert = findViewById(R.id.btnAlert)

        var arr = resources.getStringArray(R.array.cities) // Xml'de kaydettiğimiz diziyi mainde çağırdık
        for (item in arr)
        {
            Log.d("item",item)
        }

        btnAlert.setOnClickListener {
            var title = layoutInflater.inflate(R.layout.customalert,null)
            var alert = AlertDialog.Builder(this)
            alert.setCustomTitle(title)
            alert.setMessage("Are U Sure?")
            alert.setCancelable(false) // Bununla boş bir yere tıklanıldığında alert dialog'un kapanmamasını sağladık
            // buttons
            alert.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                Log.d("Yes",i.toString())

            } )
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                Log.d("No",i.toString())
            })
            alert.setNeutralButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                Log.d("Cancel",i.toString())
            })
            // alert.setIcon(R.drawable.info_icon)
            alert.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}