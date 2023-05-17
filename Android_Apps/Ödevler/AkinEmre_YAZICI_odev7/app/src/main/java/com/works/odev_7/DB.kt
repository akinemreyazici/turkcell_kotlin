package com.works.odev_7

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.works.odev_7.models.Notes

class DB(context: Context) : SQLiteOpenHelper(context, DBName, null , version)
{
    companion object
    {
        private val DBName = "notlar.db"
        private val version = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val noteTable = "CREATE TABLE \"notes\" (\n" +
                "\t\"NID\"\tINTEGER,\n" +
                "\t\"Title\"\tTEXT,\n" +
                "\t\"Detail\"\tTEXT,\n" +
                "\t\"Date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"NID\" AUTOINCREMENT)\n" +
                ");"
        p0?.execSQL(noteTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val noteTable = "DROP TABLE IF EXISTS notes"
        p0?.execSQL(noteTable)
        onCreate(p0)
    }

    fun addNote(title : String, detail : String, date : String) : Long
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("Title",title)
        values.put("Detail",detail)
        values.put("Date",date)

        val affectedRow = db.insert("notes",null,values)

        db.close()
        return affectedRow
    }

    fun showNotes() : List<Notes>
    {
        val arr = mutableListOf<Notes>()
        val db = this.readableDatabase
        val cursor = db.query("notes", null, null, null, null, null, null)
        while (cursor.moveToNext())
        {
            val nID = cursor.getInt(0)
            val title = cursor.getString(1)
            val detail = cursor.getString(2)
            val date = cursor.getString(3)

            val note = Notes(nID,title,detail,date)
            arr.add(note)
        }
        db.close()
        return arr
    }

    fun deleteNote(nID : Int) : Int
    {
        val db = this.writableDatabase
        val status = db.delete("notes","NID = $nID",null)

        db.close()
        return status
    }




}