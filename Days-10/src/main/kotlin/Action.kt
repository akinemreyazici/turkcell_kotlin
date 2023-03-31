sealed class Action
{
    constructor()
    {
        println("Action Constructor Call")
    }

    constructor(num : Int)
    {
        println("Action Call : $num")
    }
    class obj1 : Action(1)
    class obj2 : Action(2)
    class obj3 : Action(3)

    // Burada kopyaladığımız classların hepsi Action classından türetilmelidir başka bir class söz konusu olamaz


    fun call()
    {
        println("Call Call")

    }
}
