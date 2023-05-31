package com.works.days19


import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        Log.d("from","${message.from}")
        Log.d("from","${message.messageId}")
        if (message.data.isNotEmpty()) {
            Log.d("from", "${message.data}")
        }
        message.notification?.let{
            Log.d("from", "${it.body}")
        }
    }
}