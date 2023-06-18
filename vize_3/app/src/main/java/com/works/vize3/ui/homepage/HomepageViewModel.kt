package com.works.vize3.ui.homepage

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.works.vize3.firebase.repositories.FirestoreRepository
import com.works.vize3.models.Item
import com.works.vize3.models.MusicCategory
import com.works.vize3.models.MusicList
import com.works.vize3.rest.services.IMusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class HomepageViewModel : ViewModel() {
    val groupTitles = MutableLiveData<MutableList<String>>()
    val childTitles = MutableLiveData<HashMap<String, List<Item>>>()
    var isFirstLogin = true

    var musicService: IMusicService? = null
    private val firestoreRepository = FirestoreRepository()
    private var context: Context? = null
    private var editor: SharedPreferences.Editor? = null

    fun getContext(context: Context) {
        this.context = context
    }

    fun sharedPreferences() {
        //Log.d("context",context.toString())
        context?.let {
            val sharedPreferences =
                it.getSharedPreferences("musics", AppCompatActivity.MODE_PRIVATE)
            editor = sharedPreferences.edit()
            var FirstLogin = sharedPreferences.getBoolean("musics", true)
            isFirstLogin = FirstLogin
        }

    }

    fun getMusics() {
        sharedPreferences()
        //Log.d("FirstLogin", isFirstLogin.toString())

        if (isFirstLogin) {
            editor?.putBoolean("musics", false)
            editor?.commit()
            getFromRetrofit()
        } else {
            firestoreRepository.getAllMusic()?.addOnCompleteListener { task ->
                task.result.documents.forEach {
                    Log.d("Firestore", it.toString())
                    val snapshot = it.toObject(MusicCategory::class.java)
                    snapshot?.let {
                        //Log.d("Sayaç",it.toString())
                        ListItems(it)
                    }
                }

            }
        }
    }

    fun getFromRetrofit() {
        musicService?.getMusic()?.enqueue(object : Callback<MusicList> {
            override fun onResponse(call: Call<MusicList>, response: Response<MusicList>) {
                val data = response.body()

                Log.d("Data", data.toString())
                data?.musicCategories?.forEach {
                    ListItems(it)
                    Log.d("getfromretrofit", it.toString())
                    if (it.items.isNotEmpty()) {
                        it.ID = UUID.randomUUID().toString()
                        it.items.forEach {
                            it.ID = UUID.randomUUID().toString()
                        }
                        firestoreRepository.addToDatabase(it).addOnCompleteListener {
                            Log.d("document", it.isSuccessful.toString())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<MusicList>, t: Throwable) {
                Log.e("Retrofit", t.toString())
            }
        })
    }

    fun ListItems(category: MusicCategory) {
        if (groupTitles.value != null) {
            groupTitles.value!!.add(category.baseTitle)
            if (childTitles.value != null) {
                childTitles.value!![category.baseTitle] = category.items
            } else {
                childTitles.value = hashMapOf(category.baseTitle to category.items)
            }
        } else {
            groupTitles.value = mutableListOf(category.baseTitle)
        }
        Log.d("view-groupTitles", groupTitles.value.toString())
        Log.d("view-childTitles", childTitles.value.toString())
    }
}