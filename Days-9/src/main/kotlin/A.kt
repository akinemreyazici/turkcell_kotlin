open class A {

    val name = "Asya"
    protected val number  = 100 // Miras alacak olan classlarda da çağırabileceğimiz özel yetenek
    private val status = false // Aşağıdaki miras edinen classda bu değişkeni çağıramayız.

    fun fncCall()
    {
        println("$status") // kendi classı içinde kullanabiliriz.
    }

}

class B : A()
{
    fun call()
    {
        println("$name - $number")

    }
}