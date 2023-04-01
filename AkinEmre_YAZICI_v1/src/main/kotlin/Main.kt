import Question6.Question6

fun main(args: Array<String>) {

    var soru1 = Question1(245)
    println(soru1.BasamakToplam()) // 11

    var soru2 = Question2(743)
    println(soru2.reverseNum()) // 347

    var soru3 = Question3(5)
    soru3.SeriToplam() // 3.7

    var soru4 = Question4(17)
    println(soru4.getSumOfAllPrimes()) // 2 + 3 + 5 + 7 + 11 + 13 + 17 = 58

    var soru5 = Question5()
    println(soru5.isPrime(17)) // true

    var soru6 = Question6()
    println("----------------------")
    println(soru6.memurMaas(10))
    println(soru6.mudurMaas(20))
    println(soru6.genelMudurMaas(30))
    println("----------------------")

    var soru7 = Question7()
    // Sınıfın içinde bilgilendirmeler yazıyor.

    var soru8 = Question8()
    // Sınıfın içinde bilgilendirmeler yazıyor.

}