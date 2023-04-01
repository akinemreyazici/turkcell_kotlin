package Question6

open class Question6() : IQuestion6 {

    override fun memurMaas(saat : Int): Double
    {
        return 1000 + saat * 0.3
    }

    override fun mudurMaas(saat : Int): Double
    {
        return 3000 + saat * 0.6
    }

    override fun genelMudurMaas(saat : Int): Double
    {
        return 5000 + saat * 0.8
    }
}



