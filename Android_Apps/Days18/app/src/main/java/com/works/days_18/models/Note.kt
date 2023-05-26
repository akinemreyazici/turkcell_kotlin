package com.works.days_18.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true) // Birden başlayıp otomatik artırılmasını sağladık
    @ColumnInfo(name = "nid") // Databasede sütunun ismini bunu yazmasaydık default nid olucaktı biz id olmasını sağladık.
    val nid : Int?,

    val title : String?,
    val detail : String?,
    val number : Int?,

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val image : ByteArray?

)
