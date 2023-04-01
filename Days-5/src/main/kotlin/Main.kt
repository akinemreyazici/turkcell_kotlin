fun main(args: Array<String>)
{
    // List
    // Runtime --> uygulama çalışıyorken bile içerisine veri alma yada silme yeteneğine sahiptirler.

    // Array
    // Normal dizi üyeleri daha sonradan içerisine veri alamazlar, verilerin silinmeside olamaz.
    var ls1 = listOf("Ali","Veli")
    println(ls1)
    // ls1.add("Mehmet") hatalıdır.

    // Mutable Array
    var mutList1 = mutableListOf<String>()

    // Eleman ekleme
    mutList1.add("İstanbul")
    mutList1.add("İstanbul")
    mutList1.add("Ankara")
    mutList1.add("Bursa")
    mutList1.add("İzmir")
    mutList1.add(1,"Gaziantep")

    // single item
    var single = mutList1.get(0)
    var single1:String? = mutList1.getOrNull(9)

    println(mutList1)
    println(single)
    println(single1)

    single.length
    // single1.length yapamayız nullable olduğu için null kontrolü gerekir
    if (single1 != null)
    {
        single1.length
    }

    // size
    mutList1.size

    println("----------")
    // for loop
    for (item in 0..mutList1.size - 1) // Burada item index yerine geçiyor int değerdir.
    {
        println(mutList1.get(item))
    }
    println("----------")
    for (item in mutList1) // Burada ise item direk mulList1 in elemanını barındırıyor.
    {
        println(item)
    }

    //contains
    if ("İstanbul" in mutList1) // mutList1.contains("İstanbul")
    {
        println("İstanbul status : OK")
    }
    else
    {
        println("İstanbul status: false")
    }
    var statusContains = mutList1.contains("Bursa")
    println("Bursa status: $statusContains")

    // indexOf
    var index = mutList1.indexOf("İstanbul")
    println("index : $index") // 0 dan başlayıp ilk gördüğü yerdeki indexi döndürür.

    // Add List
    var list1 = mutableListOf<String>("Adana","Samsun","Adıyaman")
    var newlist = mutList1 + list1

    println(newlist) // Burada mutList1 ve list1 değerleri değişmeden yeni liste aktardık.

    mutList1.addAll(list1)
    println(mutList1)  // Burada ise mutList1 in içine list1 değerlerini ekledik mutlist1 değeri değişti.

    // Remove List items
    var removeList = mutableListOf<String>("Gaziantep","Bursa")
    var removeResult = mutList1 - removeList
    println(removeResult) // Burada mutList1 de olan belirtilen değerler olmadan yeni listeye aktarıldı.

    mutList1.removeAll(removeList)
    println(mutList1) // Burada ise mutList1 in içinden belirtilen değerler çıkartıldı. mutList1 değeri değişti.

    // Slicing
    // Parçalama yaparak yeni bir dizi oluşturma
    var sliceArr = removeResult.slice(0..3)
    // 0,1,2,3 indexlerindeki değerleri alıp diğerlerini görmezden gelerek yeni dizi oluşturduk.
    println(sliceArr)

    // filterNotNull
    var nullOrArr = mutableListOf<String?>("Ali",null,"Zehra","Veli")
    nullOrArr.add(null)
    var filterNotNullArr = nullOrArr.filterNotNull()
    println(filterNotNullArr) // Bulunan null değerlerini silip öyle değerleri aktarırız.


    // Filter
    var searchArr = mutList1.filter { item -> item.contains("d")  } // içinde d içerenleri getirmemizi sağlar.
    println(mutList1)
    println("==========")
    println(searchArr)

    // drop
    var dropArr = mutList1.drop(3) // 3 ve 3 ten sonraki indexteki değerleri döndürür.
    println(dropArr)

    // groupBy
    var groupByArr = mutList1.groupBy { item -> item.length > 5 } //verdiğimiz koşullara göre gruplara ayırmamızı sağlar
    println(groupByArr)

    // Set
    // Benzersiz değerleri kendi içinde toplama özelliği vardır
    var mutableSet1 = mutableSetOf<String>()
    mutableSet1.add("Ali")
    mutableSet1.add("Ali")
    mutableSet1.add("Ali")
    mutableSet1.add("Zehra")
    mutableSet1.add("Ayşe")
    mutableSet1.add("Mehmet")
    mutableSet1.add("Ahmet")

    // Remove
    mutableSet1.remove("Ali")

    // Remove if
    mutableSet1.removeIf { item -> item.length > 5 }
    mutableSet1.add("Zehra")

    // Normal
    mutableSet1.add("Serkan")
    println( mutableSet1 )

    // sorted
    var resultSet = mutableSet1.sorted();
    println( resultSet )

    var resultReverse = resultSet.reversed()
    println( resultReverse )




}