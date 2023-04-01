open class Question5() // open yaptım çünkü bu fonksiyonu Question4 de kullanacağım
{

    fun isPrime(number: Int): Boolean
    {

        if (number < 2) // 2 den önceki sayılar girildiğinde direk hata vermesi için koydum.
        {
            return false
        }
        for (i in 2 .. number - 1) // -1 yapmamın sebebi num un kendine bölünebiliyor olması until de kullanabilirdik
        // 2 ve üstü sayıları tek tek böldüğümde eğer kalan 0 oluyorsa tam bölünüyordur.
        // Yani asal değildir.
        {
            if (number % i == 0) {
                return false
            }
        }
        return true // Bu döngüden sağlam çıkıyorsa true döndürürüm yani asaldır.
    }
}
