package com.works.vize3.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.works.vize3.R
import com.works.vize3.common.GlideImage
import com.works.vize3.models.FavoriteMusic

class FavoriteMusicListViewAdapter(
    private val context: Activity,
    private val list: List<FavoriteMusic>
) : ArrayAdapter<FavoriteMusic>(
    context,
    R.layout.favourites_list, list
) {
    private var ListView: ListView? = null
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.favourites_list, null, true)
        val r_title = rootView.findViewById<TextView>(R.id.r_Title)
        val r_image = rootView.findViewById<ImageView>(R.id.r_Img)

        val music = list.get(position)
        r_title.text = music.title
        val glide = GlideImage
        Glide.with(context).load(glide.star).into(r_image)



        return rootView
    }

    fun makeListView(listView: ListView) {
        ListView = listView
        notifyDataSetChanged()
    }

}