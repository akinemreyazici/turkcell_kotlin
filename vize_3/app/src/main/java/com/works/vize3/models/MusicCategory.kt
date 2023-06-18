package com.works.vize3.models

data class MusicCategory(
    var ID : String = "",
    val baseTitle: String = "",
    val items: List<Item> = listOf()
)