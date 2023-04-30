package com.works.days_9

import com.works.days_9.models.Currency
import com.works.days_9.models.Plant
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


class XmlResult {

    fun xmlCatalog() : List<Plant>
    {
        val arr = mutableListOf<Plant>()
        val url = "https://www.w3schools.com/xml/plant_catalog.xml"
        val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        // Log.d("xml",doc.toString())
        val elements : Elements = doc.getElementsByTag("PLANT")

        for (item in elements)
        {
            val COMMON = item.getElementsByTag("COMMON").text()
            val BOTANICAL = item.getElementsByTag("BOTANICAL").text()
            val ZONE = item.getElementsByTag("ZONE").text()
            val LIGHT = item.getElementsByTag("LIGHT").text()
            val PRICE = item.getElementsByTag("PRICE").text()
            /*
            Log.d("COMMON",COMMON)
            Log.d("BOTANICAL",BOTANICAL)
            Log.d("ZONE",ZONE)

             */
            val plant = Plant(COMMON,BOTANICAL,ZONE,LIGHT,PRICE)
            arr.add(plant)
        }

        return arr
    }

    fun xmlCurrency() : List<Currency>
    {
        val arr = mutableListOf<Currency>()
        val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
        val doc : Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val elements : Elements = doc.getElementsByTag("Currency")

        for (item in elements)
        {
            val Unit = item.getElementsByTag("Unit").text()
            val Isim = item.getElementsByTag("Isim").text()
            val CurrencyName = item.getElementsByTag("CurrencyName").text()
            val ForexBuying = item.getElementsByTag("ForexBuying").text()
            val ForexSelling = item.getElementsByTag("ForexSelling").text()
            val BanknoteBuying = item.getElementsByTag("BanknoteBuying").text()
            val BanknoteSelling = item.getElementsByTag("BanknoteSelling").text()
            val CrossRateUSD = item.getElementsByTag("CrossRateUSD").text()
            val CrossRateOther = item.getElementsByTag("CrossRateOther").text()

            val currency = Currency(Unit,Isim,CurrencyName,ForexBuying,ForexSelling,BanknoteBuying,BanknoteSelling,CrossRateUSD,CrossRateOther)
            arr.add(currency)
        }
        return arr

    }
}