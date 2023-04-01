class C : B("Emre")
{
    override fun toString(): String {
        return "{C Class Call}"
    }
    fun mail(send : String, to:String)
    {
        println("Send : $send to : $to")
    }
}