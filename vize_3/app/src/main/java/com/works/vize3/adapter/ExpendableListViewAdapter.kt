package com.works.vize3.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import com.works.vize3.R
import com.works.vize3.models.Item


class ExpendableListViewAdapter
    (
    private val context: Context) : BaseExpandableListAdapter()
{
    private var categoryList = mutableListOf<String>()
    private var musicList = hashMapOf<String,List<Item>>()
    private var ListView : ExpandableListView? = null
    override fun getGroupCount(): Int {
        return categoryList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        Log.d("count",musicList.size.toString())
        return this.musicList[this.categoryList[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return categoryList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return this.musicList[this.categoryList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView = p2
        var groupTitle = getGroup(p0) as String

        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.category_list, null)
        }
        val txtMusicCategory = convertView!!.findViewById<TextView>(R.id.txtMusicCategory)
        txtMusicCategory.text = groupTitle
        txtMusicCategory?.setOnClickListener {
            if(ListView!!.isGroupExpanded(p0)){
                ListView?.collapseGroup(p0)
            }else{
                ListView?.expandGroup(p0)
            }
        }

        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView = p3
        var childTitle = getChild(p0,p1) as Item

        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.music_list,null)
        }
        val txtMusicCategory = convertView!!.findViewById<TextView>(R.id.txtMusicName)
        txtMusicCategory.text = childTitle.title
        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    fun submitGroupList(list : MutableList<String>){
        categoryList = list
        notifyDataSetChanged()
    }

    fun submitChildList(list : HashMap<String,List<Item>>){
        musicList = list
        notifyDataSetChanged()
    }

    fun makeListView(listView : ExpandableListView){
        ListView = listView
        notifyDataSetChanged()
    }
}