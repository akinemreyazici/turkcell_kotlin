package com.works.days19.models


data class Note(
    val key : String ,
    val value : NoteVal
)

data class NoteVal(
    val title : String = "",
    val detail : String = ""
)
