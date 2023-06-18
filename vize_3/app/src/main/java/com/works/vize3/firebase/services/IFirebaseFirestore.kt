package com.works.vize3.firebase.services

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.works.vize3.models.FavoriteMusic
import com.works.vize3.models.MusicCategory

interface IFirebaseFirestore {

    fun getAllMusic(): Task<QuerySnapshot>?

    fun addToDatabase(category: MusicCategory): Task<DocumentReference>

    fun addToFavorites(music: FavoriteMusic): Task<Void>

    fun getAllFavorites(): Task<QuerySnapshot>?

    fun deleteFromFavorites(ID: String): Task<Void>

    fun getFavouriteByID(ID: String): Task<DocumentSnapshot>?
}