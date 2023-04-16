package com.works.days_7

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    lateinit var detailWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detailWebView = findViewById(R.id.detailWebView)
        //val url = "https://www.google.com.tr/"
        //val url = "https://youtu.be/E7_8ohV6Zgg"

        // WebView Url open page
        //detailWebView.settings.javaScriptEnabled = true
        //detailWebView.webViewClient = customWebViewClient()
        //detailWebView.loadUrl(url)


        // WebView data open page
        val data ="Araba parasına, her özellik mevcut. O kadar ki; tost makinesine ihtiyacınız kalmayacak! Geliştiriciler için oldukça kıymetli diyebiliriz.!!\r\n<br>\r\n<table  class=\"table table-hover\\\" ><thead><tr><th>Marka</th><th>Model</th><th>Fiyat</th></tr></thead><tbody><tr><td>iPhone</td><td>XS</td><td>10000</td></tr><tr><td>iPhone</td><td>11</td><td>15000</td></tr></tbody></table>"
        val html ="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ\" crossorigin=\"anonymous\">\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\" crossorigin=\"anonymous\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">" +
                "$data\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>"
        detailWebView.loadData(html,"text/html", "utf-8")

    }

    class customWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            Log.d("shouldOverrideUrlLoading", "Loading")
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            Log.d("onPageFinished", "Finish")
            super.onPageFinished(view, url)
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            Log.d("onPageStarted","Start")
            super.onPageStarted(view, url, favicon)
        }
    }
}