package com.works.days19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.works.days19.models.*
import java.util.Random
import java.util.UUID

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("MainActivity", "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }
                // Get new FCM registration token
                val token = task.result

                // Log and toast
                val msg = "Token : " + token
                Log.d("MainActivity", msg)

            }
        )
         */

        // Firebase Realtime Database Using
        val db = FirebaseDatabase.getInstance().getReference("notes")
        //for (i in 0..5) {
            val fid = db.push().key
            val number = Random().nextInt(99) + 1
            val dt = NoteVal("Toplantı - $number", "Detay toplantı")
            //db.child(UUID.randomUUID().toString()).setValue(dt)
            db.child(fid!!).setValue(dt).addOnCompleteListener {
                Toast.makeText(this, "Save succesfull", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()

            }
        //}

        // data list
        db.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists())
                {
                    snapshot.children.forEach {
                        val noteVal = it.getValue(NoteVal::class.java)
                        val note = Note(it.key!!,noteVal!!)
                        Log.d("note",note.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,error.message, Toast.LENGTH_LONG).show()
            }

        })

        Log.d("ayrac","----------------------------------")

        db.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists())
               {
                   snapshot.children.forEach {
                       Log.d("single",it.toString())
                   }
               }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("error",error.message)
            }

        })

    }
}