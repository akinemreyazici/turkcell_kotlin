class Question1 {
    var number : Int = 0
    constructor(_number : Int)
    {
        number = _number
    }
    // Böylelikle istenilen hangi basamaklı sayı olursa olsun bize toplamını verecek bir fonksiyon oluşturduk.
    fun BasamakToplam() : Int
    {
        var toplam = 0

        while (number > 0)
        {
            toplam += number % 10 // Burada birler basamağındaki değeri üstüne ekleyip sayımızın basamağını küçültüyoruz
            number = number / 10
        }
        return toplam
    }
}