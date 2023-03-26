class Action constructor(val name: String,val age: Int)
{
    init {
        println("Init call $name")
    }

    fun call(number1 : Int, number2 : Int)
    {
        val sum = number1 + number2
        println("Sum = $sum")
    }


}