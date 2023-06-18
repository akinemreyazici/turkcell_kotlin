package com.works.vize3.ui.musicDetail

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.works.vize3.firebase.repositories.FirestoreRepository
import com.works.vize3.models.FavoriteMusic

class MusicDetailViewModel : ViewModel() {
    var VolumeLevel = 50
    private var context: Context? = null
    private val firestoreRepository = FirestoreRepository()
    private var editor: SharedPreferences.Editor? = null
    var isFavourite = MutableLiveData<Boolean>()

    fun getContext(context: Context) {
        this.context = context
    }

    fun sharedPreferences() {

        context?.let {
            val sharedPreferences =
                it.getSharedPreferences("volume", AppCompatActivity.MODE_PRIVATE)
            editor = sharedPreferences.edit()
            var volumeLevel = sharedPreferences.getInt("volume", 50)
            VolumeLevel = volumeLevel
            Log.d("SharedPrefVolume", VolumeLevel.toString())
        }

    }

    fun getVolume(): Int {
        sharedPreferences()
        if (VolumeLevel != 50) {
            saveVolume(VolumeLevel)
        }
        Log.d("GetVolume", VolumeLevel.toString())
        return VolumeLevel
    }

    fun saveVolume(volumeLevel: Int) {
        editor?.putInt("volume", volumeLevel)
        editor?.commit()
    }

    fun addToFavorites(music: FavoriteMusic) {
        firestoreRepository.addToFavorites(music)?.addOnCompleteListener {
            Log.d("Favorites", it.isSuccessful.toString())
            isFavourite.postValue(true)
        }
    }

    fun deleteFromFavorites(ID: String) {
        firestoreRepository.deleteFromFavorites(ID)?.addOnCompleteListener {
            Log.d("Favorites", it.isSuccessful.toString())
        }
        isFavourite.postValue(false)
    }

    fun checkIfMusicIsFavorited(musicId: String) {
        firestoreRepository.getFavouriteByID(musicId).addOnSuccessListener { documentSnapshot ->
            val isFavorited = documentSnapshot.exists()
            isFavourite.postValue(isFavorited)
        }
    }

}