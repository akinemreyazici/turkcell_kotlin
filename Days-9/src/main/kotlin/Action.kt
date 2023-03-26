private  class Action{

    // Private -> class -> sadece kendi dosyası içinde görünebilme yeteneği
    // Private -> variable -> sadece kendi classı içinde görünebilme yeteneği
    private val age = 40


    // Public -> Default -> Classı erişime uygun her yerden görünebilme yeteneğine sahip
    val name = "Ali Bilmem"
}

class PrClass
{
    fun call()
    {
        var ac1 = Action() // Private değişken olduğu için ac1.age olmaz göremeyiz.
        ac1.name // Public değişken olduğu için görebiliriz.
    }
}