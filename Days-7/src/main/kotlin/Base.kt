open class Base
{
    var _a : Int = 0
    constructor()
    {
        println("Base Constructor call")
    }

    constructor(a : Int)
    {
        _a = a
    }
    open fun create(): String
    {
        return "Base Create Call"
    }
    // Override edilecek fonksiyonun aldığı parametreler ve döndürdüğü değerler aynı olmak zorundadır

    fun price() : Int {
        return _a * _a
    }
}