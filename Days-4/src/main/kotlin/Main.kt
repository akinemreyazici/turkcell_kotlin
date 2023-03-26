fun main(args: Array<String>) {

   var count = 10;
   var  result = if(count > 9)
    {
        callPrint()
        true // En sondaki değeri result a atamış oluruz. Ondan önce başka işlemler yapabiliriz.
    }
    else
    {
        "Selam"
    }
    println(result)

    // Hatalı kullanım (Kotlin'de ternary yoktur)
    // var result1 = (count > 9) ? "Büyük" : "Küçük"

    var result1 = if (count > 10) "Büyük" else "Küçük"
    println(result1)

    // when
    var str = "Ankara"
    when (str) {
        "Ankara" -> multiLine("Ankara")
        "İstanbul" -> println("İstanbul")
        "İzmir" -> println("İzmir")
        "Yalova" -> println("Yalova")
        else -> println("City empty")

    }

    var countx = 10
    when (countx) {
        in 1..5 -> println("1 ve 5 arasındadır.")
        in 6..10 -> println("6 ile 10 arasındadır.")
        else -> println("Empty!")
    }

    // for
    var arr = arrayOf("Murat","Akın","Emre","Zehra","Yazıcı")
    for(item in arr)
    {
        println(item)
    }
    println("==========")
    for (item in 0..arr.size -1) {
        var strItem = arr[item]
        if(strItem == "Akın")
        {
            println("Akın sayılmadı")
            continue // Continue ulaşıldığında bulunduğu aşamada işlemleri yapmadan bir sonraki aşamaya atlar.
        }
        if(strItem == "Zehra") {
            println("Zehra found")
            break // Break ulaşıldığında bulunduğu döngüden çıkar devam etmez.
        }else
            println("For call : $strItem")
    }
    println("---------------")
    var itr = arr.iterator()
    while(itr.hasNext() )
    {
        println(itr.next())
    }
    // "Murat","Akın","Emre","Zehra","Yazıcı")
    println("---------------")
    while(itr.hasNext() )
    {
        println(itr.next())
    }

    var i = 0
    while(i < 5)
    {
        println("While call : $i")
        i++
    }
    println("---------------")

    var x = 0
    do {
        println("X line call $x")
        x++
    }while (x < 10) //DoWhile'ın While'dan farkı while içinde koşul doğru olmasa dahi bir kez çalıştırmamıza yarıyor.




}
fun callPrint()
{
    println("Call Print Line")
}

fun multiLine(b : String)
{
    println(b)
    println("Deneme")
}