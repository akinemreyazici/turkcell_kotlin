package com.works.days_5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var btnAlert : Button
    lateinit var btnContext : Button
    lateinit var listContext : ListView
    var itemSelect = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAlert = findViewById(R.id.btnAlert)
        btnContext = findViewById(R.id.btnContext)
        listContext = findViewById(R.id.listContext)

        //context register

        registerForContextMenu(btnContext)
        registerForContextMenu(listContext)

        var arr = resources.getStringArray(R.array.cities) // Xml'de kaydettiğimiz diziyi mainde çağırdık

        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr)
        listContext.adapter = adapter
        for (item in arr)
        {
            Log.d("item",item)
        }

        btnAlert.setOnClickListener {
            alertDialog()
        }

        listContext.setOnItemLongClickListener { adapterView, view, i, l ->
            Log.d("position",arr[i] )
            itemSelect = arr[i]
            false
        }
    }



    fun alertDialog()
    {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.profile -> {
                Log.d("profile","Profile")
            }
            R.id.settings -> {
                Log.d("settings", "Settings")
            }
            R.id.logout -> {
                Log.d("logout","Logout")
                alertDialog()

            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Context Menu Config

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_menu, menu) // Uzun tıklamak gerekiyor
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.profile -> {
                Log.d("profile",itemSelect)

            }
            R.id.settings -> {
                Log.d("settings", itemSelect)
            }
            R.id.logout -> {
                Log.d("logout",itemSelect)
                alertDialog()

            }
        }
        return super.onContextItemSelected(item)
    }
}