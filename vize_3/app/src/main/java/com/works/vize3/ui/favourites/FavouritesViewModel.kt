package com.works.vize3.ui.favourites

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.works.vize3.firebase.repositories.FirestoreRepository
import com.works.vize3.models.FavoriteMusic

class FavouritesViewModel : ViewModel() {

    private val firestoreRepository = FirestoreRepository()
    val favoriteMusicList: MutableLiveData<MutableList<FavoriteMusic>> = MutableLiveData()


    fun getAllFavorites() {
        firestoreRepository.getAllFavorites()?.addOnSuccessListener { querySnapshot ->

            // Firestore'dan gelen veriyi FavoriteMusic listesine dönüştür
            val favorites = querySnapshot.documents.mapNotNull {
                val music = it.toObject(FavoriteMusic::class.java)
                Log.d("music", music.toString())
                if (music != null) {

                    if (favoriteMusicList.value != null) {
                        favoriteMusicList.value!!.add(music)
                        Log.d("favoritelist", favoriteMusicList.value.toString())

                    } else {
                        favoriteMusicList.value = mutableListOf(music)
                        Log.d("favoritelist", favoriteMusicList.value.toString())

                    }

                }
            }
        }
    }

    fun deleteFromFavorites(ID: String) {
        firestoreRepository.deleteFromFavorites(ID)

    }


}
