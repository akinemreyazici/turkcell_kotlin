package com.works.days8

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class Result
{
    fun news ()
    {
        val url = "https://www.haberler.com"
        val document : Document = Jsoup.connect(url).timeout(15000).get()

        Log.d("Title", document.title())
    }
}