package com.works.odev_7.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.works.odev_7.R
import com.works.odev_7.models.Notes

class NoteListAdapter(
    private val context : Activity,
    private val list : List<Notes>
) : ArrayAdapter<Notes>(context,R.layout.notes_list,list)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rootView = context.layoutInflater.inflate(R.layout.notes_list,null,true)


        val r_Title = rootView.findViewById<TextView>(R.id.r_title)

        val note = list.get(position)

        r_Title.text = note.Title

        return rootView
    }
}