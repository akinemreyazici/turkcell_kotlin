fun main(args: Array<String>) {

    // Arrays -> Diziler
    // Bir değişken içinde birden fazla değer tutmak içinde kullanılır.


    // dizi oluşturma
    var cities = arrayOf("Ankara", "Yalova", "Yalova", "Ankara", "İstanbul", "Bursa")


    // dizi item ulaşım
    println(cities[0])

    // item add
    cities = cities.plus("Hatay")
    println(cities[4])
    // println(cities[7]) -> ArrayOutOfBounds Exception erroru görürüz.

    // size
    println(cities.size)

    // tersine yazdırma
    cities.reverse() // var olan diziyi tersine çevirir
    var new = cities.reversed() // tersine çevirilmiş diziyi string list olarak döndürür

    //distinct
    //Tekrarlanan verilerin sadece bir tanesinin kullanılması için geçerlidir.
    var arrayList = cities.distinct()
    for (item in arrayList)
    {
        println(item)
    }
    println("-----------------")

    // tüm elemanları ayrı ayrı yazdırma
    for (item in cities)
    {
        println(item)
    }

    // get
    println(cities.get(0))  // cities[0] farkı olmayan fonksiyon

    // set
    cities.set(1,"Adıyaman")  // Verilen indexteki elemanı değiştirdiğimiz fonksiyon
    println(cities.get(1))

    // array in item search
    var city = "Hatay"
    if(city in cities)
    {
        println("$city cities dizisinde vardır")
    }
    else
    {
        println("$city cities dizisinde yoktur")
    }
    var city2 = "Kastamonu"
    if(city2 in cities)
    {
        println("$city2 cities dizisinde vardır")
    }
    else
    {
        println("$city2 cities dizisinde yoktur")
    }

    // drop
    // belirli bir index elemanından başlayıp diziyi değiştir.
    println("=======================")
    for(item in cities)
    {
        println(item)
    }
    var dropList = cities.drop(3)
    println("=======================")
    for(item in dropList)
    {
        println(item)
    }
    // dropLast
    // belirli bir indexten sonraki elemanları silip diziyi değiştir.
    println("=======================")
    var dropLastList = cities.dropLast(3)
    for(item in dropLastList)
    {
        println(item)
    }

    // Range
    // Aralık belirterek bir dizinin işlemin yapılmasını sağlar

    for (item in 3..8)
    {
        println(item)
    }
    println("=========")
    //downTo
    for (item in 10 downTo 3)
        println(item)  // Süslü parantez kullanmazsak altındaki tek satırdaki kodu çalıştırır.
    println("This line call")

    // step
    for (item in 1..20 step 4) // Kaçar kaçar artacağını belirtiriz
    {
        println(item)
    }

    // char range
    for (item in 'a'..'e')
        println(item)

    println("---------------")

    // reversed
    for (item in ('a'..'e').reversed())
        println(item)

    println("---------------")

    for (item in (1..50).reversed() step 5)
    {
        println(item)
    }

    // filter **
    var arr1 = (1..100).filter { item -> item % 7 == 0}
    println(arr1)

    var arr2 = cities.filter { item -> item.contains("a")}
    println(arr2)

    var val1 = 1..100 step 3
    println(val1.maxOrNull())
    println(val1.minOrNull())
    println(val1.sum())

    noParams()
    sum(10,5)
    sum(20,115)
    println(sumReturn(12,23))
    var lists = order("Ali",30)
    println(lists.get(0))
    println(lists.get(1))
    println(calculate(10,20, ::sumx))
}
fun noParams()
{
    println("noParams call")
}

fun sum(sum1 : Int ,sum2 : Int )
{
    var toplam = sum1 + sum2
    println("$sum1 ve $sum2 nin toplamı = $toplam")
}

fun sumReturn(sum1 : Int, sum2: Int) : Int
{
    return sum1 + sum2
}

fun order(str:String, number: Int): List<Any>
{
    var arr = arrayListOf<Any>(str + " YAZICI",number + 10)
    return arr
}

fun sumx (a: Int, b: Int) = a + b

fun calculate(a: Int, b: Int, operation:(Int,Int) -> Int) : Int
{
    return operation(a,b)
}

