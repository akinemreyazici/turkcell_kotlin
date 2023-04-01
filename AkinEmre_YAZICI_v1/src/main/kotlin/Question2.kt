class Question2
{
    var num : Int = 0
    constructor(number : Int)
    {
        num = number
    }
    fun reverseNum() : Int
    {
        var stringNum = num.toString()
        var lastNum : Int = stringNum.reversed().toInt()
        /* Burada önce sayıyı stringe çevirdim. Daha sonrasında String classının reversed fonksiyonundan yararlanarak
        sayımı ters çevirdikten sonra bunu yeni bir değişkene bunu atayarak döndürdüm.
         */
        return lastNum
    }

}