abstract class User()
{

    abstract fun userNumber() : Int
    abstract fun userTC() : Int // Bu gövdesiz fonksiyonlar mutlaka bu classı miras edinen yeni classta override edilmeliler

    fun userName(): String
    {
        if( userNumber() == 100)
        /*    Burada bu fonksiyon dolu olmasada abstract özelliğiyle bunun başka yerde dolu
           olması gerektiğinden Customer chill classından override edilmiş fonksiyonu çağırır */
        {
            return "Ali Bilmem"
        }
        else if( userNumber() == 200)
        {
            return "Erkan Bilsin"
        }
        else
        {
            return ""
        }
    }

    fun userTotal() : Int
    {
        if( userNumber() == 100)
        {
            return 55000
        }
        else if( userNumber() == 200)
        {
            return 65000
        }
        else
        {
            return 0
        }
    }
}

/* Keywords
    -Polimorfizm


 */