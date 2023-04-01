class Question3
{
    var num : Int = 0
    constructor(N : Int)
    {
        num = N
    }
    fun SeriToplam()
    {
        var toplam = 1.0 // 1 den başladığı için koydum
        var faktoriyel = 1.0 // Faktoriyel baslangıc 1 den başlamalı
        for (i in 1..num)
        {
            faktoriyel *= i
            //println(faktoriyel) -> Faktoriyel kontrol
            toplam += i / faktoriyel


        }
        println("1 + 1/1! + 2/2! + 3/3! + .... + $num/$num! = $toplam")
        // Burada sonucu döndürmek yerine pdfteki gibi gözüksün diye println ile göstermek istedim.
    }

}