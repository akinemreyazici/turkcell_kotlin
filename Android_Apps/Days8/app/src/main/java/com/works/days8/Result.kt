package com.works.days8

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class Result {
    fun news(): List<NewsData> {
        val arr = mutableListOf<NewsData>()
        val url = "https://www.haberler.com"
        val document: Document = Jsoup.connect(url).timeout(15000).get()
        val elements: Elements = document.getElementsByAttribute("data-headlinenumber")
        for (item in elements) {
            // Log.d("item",item.getElementsByTag("img").toString())
            val img = item.getElementsByTag("img")

            val title = img.attr("alt")
            val src = img.attr("data-src")
            val href = item.attr("abs:href")

            if (title != "" && href != "" && src != "") // data-headlinernumber da 50 tane attirbute var ama sadece 25'i slide içinde olduğu için kontrole sokuyoruz
            {
                //Log.d("title", title)
                //Log.d("href", href)
                //Log.d("src", src)
                val news = NewsData(title, src, href)
                arr.add(news)
            }


        }

        return arr

        // Log.d("Title", document.title())
    }
}