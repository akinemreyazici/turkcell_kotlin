fun main(args: Array<String>) {

    //Map
    //Key, Val
    var map1 = mapOf<String,String>("name" to "Ali","surname" to "Bilmem","name" to "Erkan")
    //println(map1.get("xyz")) böyle bir key olmadığından null döndürür.

    println(map1.get("name")) // en son kaydedilen key değeri gözükür.

    var map = mutableMapOf<String,String>()
    map.put("name","Ali")
    map.put("surname","Bilmem")
    map.put("email","ali@mail.com")
    map.put("status","false")
    map.put("class","4.Class")
    println(map.get("name"))

    //all keys
    println("=========")
    var keys = map.keys
    for (key in keys)
    {
        println(map.get(key))
    }
    println("=========")
    for ((k,v) in map)
    {
        println("Key : $k --> Value : $v ")
    }
    println("=========")
    map.forEach{(k,v) ->
        println("k : $k v : $v")
    }

    println(map.size)
    println(map.count())

    if (map.containsKey("name"))
    {
        println(map.get("name"))
    }

    // key control
    if ("name" in map)
    {
        println(map.get("name"))
    }

    //remove
    map.remove("name")

    //key sorted
    var resultMap = map.toSortedMap()
    println(resultMap)

    //filter
    var resultFilterValues = map.filterValues { item -> item.length > 6 } // keylerde kaydedilen değerlerin uzunluğu 6 dan büyük olanları getir
    println("resultFilterValues : $resultFilterValues")

    var resultFilterKeys = map.filterKeys { item -> item.length > 5 } // key uzunluğu 5 den büyük olanları getir.
    println("resultFilterKeys : $resultFilterKeys ")

    var resultFilter = map.filter { item -> item.key.length > 3 } // hem key hem value değerini kullanarak yapabileceğimiz yöntem
    println("resultFilter : $resultFilter")

    println(map)

    // Nesne üretim işlemi
    // Object
    var actionObj = Action(100)
    actionObj.name = "Serkan Bilki"
    println(actionObj.name)

    var actionObj1 = Action()
    println(actionObj1.name)

    var size = actionObj1.stringSize("Ali Bilsin")
    println(size)

    var newNum = Action.num



}
