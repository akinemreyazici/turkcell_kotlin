class Action
{
    public var name = "Erkan Bilsin"
    private var number = 10 // Private olduğu zaman sadece kendi sınıfının içinde kullanabileceğimiz bir değişken olur.
    var settings = Settings()
    companion object{
        var num = 100 // Program çalıştığı sürece hafızada yer almaya devam eder.
    }
    init {
        println(name)
        println("init call ") // class çağırıldığından her şeyden önce init çalışır
    }
    // Primary constructor , standartlarımız(attributes) , init ve son olarak secondary constructor çalışır.
    constructor(_number : Int)
    {
        this.number = _number // this koymak zorunda değiliz fakat _number da number olsaydı karışmaması açısından this ile garantiliyoruz
        println("_number contsruct call")
    }

    constructor()
    {
        println("null construct call")
    }


    fun stringSize( data : String) : Int
    {
        call()
        return data.length + number
    }

    private fun call()
    {
        println("Call Line")
    }
}