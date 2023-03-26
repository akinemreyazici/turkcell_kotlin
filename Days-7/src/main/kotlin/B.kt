open class B constructor(_name : String) : Base(10)
{
    var name = _name
    fun sales() : String
    {
        if(_a > 50)
        {
            create()
        }
        else
        {
            super.create() // Override edilmemiş , fonksiyonun ilk halini çağırmış oluruz.
        }
        return "B Sales"
    }

    override fun create() : String
    {
        return "Create B Product"
    }

}