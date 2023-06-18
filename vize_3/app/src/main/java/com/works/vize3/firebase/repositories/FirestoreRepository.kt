package com.works.vize3.firebase.repositories

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.works.vize3.firebase.services.IFirebaseFirestore
import com.works.vize3.models.FavoriteMusic
import com.works.vize3.models.MusicCategory

class FirestoreRepository : IFirebaseFirestore {


    override fun getAllMusic(): Task<QuerySnapshot> {
        val db = FirebaseFirestore.getInstance().collection("Music Category")
        return db.get()
    }

    override fun addToDatabase(category: MusicCategory): Task<DocumentReference> {
        val db = FirebaseFirestore.getInstance().collection("Music Category")
        return db.add(category)
    }

    override fun addToFavorites(music: FavoriteMusic): Task<Void> {
        val db = FirebaseFirestore.getInstance().collection("Favorites")
        return db.document(music.ID).set(music)
    }

    override fun getAllFavorites(): Task<QuerySnapshot> {
        val db = FirebaseFirestore.getInstance().collection("Favorites")
        return db.get()
    }

    override fun deleteFromFavorites(ID: String): Task<Void> {
        val db = FirebaseFirestore.getInstance().collection("Favorites")
        return db.document(ID).delete()
    }

    override fun getFavouriteByID(ID: String): Task<DocumentSnapshot> {
        val db = FirebaseFirestore.getInstance().collection("Favorites")
        return db.document(ID).get()
    }

}