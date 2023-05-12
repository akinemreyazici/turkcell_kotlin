package com.works.days_13

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.works.days_13.models.Note

class DB(context: Context) : SQLiteOpenHelper(context, DBName, null, Version) {

    companion object {
        private val DBName = "notes.db"
        private val Version = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val noteTable = "CREATE TABLE \"note\" (\n" +
                "\t\"nid\"\tINTEGER,\n" +
                "\t\"title\"\tTEXT,\n" +
                "\t\"detail\"\tTEXT,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"nid\" AUTOINCREMENT)\n" +
                ");"
        p0?.execSQL(noteTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val noteTable = "DROP TABLE IF EXISTS note"
        p0?.execSQL(noteTable)
        onCreate(p0)
    }


    fun addNote(title: String, detail: String, date: String): Long {
        val db =
            this.writableDatabase // Eğer database içine işlemler yapılıyorsa writable , okumak select etmek istiyorsanı readable kullanıyorsun.
        val values = ContentValues()
        values.put("title", title)
        values.put("detail", detail)
        values.put("date", date)

        val effectRow = db.insert("note", null, values)
        db.close()
        return effectRow
    }

    fun allNote() : List<Note> {
        val arr = mutableListOf<Note>()
        val db = this.readableDatabase
        val cursor = db.query("note", null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val nid = cursor.getInt(0) // Sütun sırasıyla index ini seçerek burdan gittik, databasemizde nid ilk başlayan sütunda o yüzden 0 ı aldık.
            //Log.d("nid",nid.toString())
            val title = cursor.getString(1)
            val detail = cursor.getString(2)
            val date = cursor.getString(3)

            val note = Note(nid, title, detail, date)
            arr.add(note)
        }
        db.close()
        return arr
    }

    fun deleteNote(nid : Int) : Int
    {
        val db = this.writableDatabase
        val status = db.delete("note", "nid = $nid", null)

        db.close()
        return status
    }

    fun updateNote(nid : Int, title : String, detail: String) : Int
    {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("nid",nid)
        values.put("title",title)
        values.put("detail",detail)
        val status = db.update("note",values,"nid = $nid",null)
        db.close()
        return status
    }


}