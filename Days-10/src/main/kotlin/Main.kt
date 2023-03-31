fun main(args: Array<String>) {


    var ac : Action = Action.obj2()


    val item = when(ac)
    {
        is Action.obj1 -> ac.call()
        is Action.obj2 -> 2
        is Action.obj3 -> false
        else -> "Not found"
    }
    println(item)

    var profile = Profile<String>("deneme")
    val itemx = profile.call("Profile")
    println(itemx)

    var profileX = Profile<User>()
    var arr = mutableListOf<User>()

    var base1 = BaseImpl()
    DelegateClass(base1).token("token_123")
    DelegateClass(base1).security("Ali")

    // Connection conn;
    try {
        // Hata olma olasılığı olan kodlar yazılır.
        // conn.open()
        val num1 = 100
        val num2 = 0
        val end = num1 / num2
        println(end)
        // Burada try içindeyken bir hata görüldüğünde direk exceptiona gireriz ve altındaki kodlar çalışmaz.
        // Böyle bir durumda mesela uygulamamızı kapatmak istediğimizde finally adlı bölümde her daim kapatabiliriz.
    }catch (ex : Exception)
    {
        // Hata varsa çalışan kodlarda burada yazılır.
        println("Lütfen sayısal ve sıfır olmayan bir değer giriniz.")
    }
    finally {
        // Her durumda çalışmasını istediğimiz kodlar
        // conn.close()
    }
    println("This line Call")

    // Aşağıda kodun aksine burada hata olduktan sonra program derlenmeye devam ettiğinden bu println ı görürüz

    /*
    val num1 = 100
    val num2 = 0
    val end = num1 / num2
    println(end)

    // ArithmeticException (/ by zero) hatası alacağımızdan aşağıda kod satırını asla göremeyiz.
    println("This line Call")
    */

}