package com.works.days_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tink = TinkEncDec()
        val cipherText = tink.encrpyt("123456789")
        Log.d("cipherText",cipherText)
        val decryptedText = tink.decrypt(cipherText)
        Log.d("decryptedText", decryptedText)
    }
}