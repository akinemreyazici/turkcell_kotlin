class Question4 (private val num : Int) : Question5() // Burada bazı fonksiyonları miras alacağımızdan miras edindik.
{
    // yukarıda primary constructordan aldığım değeri fonksiyonda kullanarak yaptım fonksiyon içinde input değer isteyerek yapabilirdik.
    fun getSumOfAllPrimes() : Int
    {
        var toplam = 0
        for (i in 2..num) // Burada 2 den başlayarak tek tek tüm sayıları asal mı diye kontrol ettiriyoruz
        {
            if (isPrime(i)) // Soruda belirliten isPrime methodunu aslında Question5 classında oluşturduğumdan tekrar oluşturmadım
            /* Eğer bu indexteki sayı asal sayı ise fonksiyon true döndüreceğinden
            içeri girer ve toplama eklenir. */
            {
                toplam += i
            }
        }
        return toplam

    }
}