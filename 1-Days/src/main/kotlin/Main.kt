fun main(args: Array<String>) {
    println(args.joinToString())

    // Kotlinde ; gerekli değildir
    println("Hello Kotlin")
    println(10 * 50)
    //println(10 / 0)
    print("Kemal"); print("Bilirim")
    println("Bilsin")
    println("Bilki")

    // Değişkenler
    /*
        Multi line
        comment
     */

    // String
    // Karakter Katarı

    var name = "Ali"
    println(name)
    var surname: String = "Bilmem"
    name = "Kemal"
    println(name)
    var nick = 20
    println(20 + nick.toInt())

    //Int
    //Tamsayı

    var age: Int = 2147000000
    var num: Byte = 127
    var num1: Short = 32700
    var num2: Long = 1312312242422345642

    //Boolean Type
    //True - False
    var status: Boolean = true

    //Float, Double
    //Ondalıklı Değerler
    var on1: Float = 10.5f
    var on2: Double = 34546546.5

    // Char
    //İçerisine sadece 1 karakter atılabilen değerlerdir.
    var c1 = 'A'

    //Type Casting
    //Tür dönüşümü
    var stNum = "100"
    println(10 + stNum.toInt())
    var Num = 100
    println(Num.toString() + " Değeri")


}