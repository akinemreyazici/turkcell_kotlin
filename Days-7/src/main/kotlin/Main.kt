fun main(args: Array<String>) {

    val action = Action("Akın",21)
    action.call(40,60)
    // val profile = Profile()

    val objA = A(11)
    println("Title : ${objA.title()}| Price : ${objA.price()}") // fonksiyon çağırmak göstermek için süslü parentez içinde yazılarak çağırılır.
    println(objA.create()) // Base de bulunan create fonksiyonu B class içinde override edilerek tekrardan düzenlendi

    println("---------------------")

    val objB = B()
    println("Title : B Product Sales : ${objB.sales()}")
    println(objB.create()) // Base de bulunan create fonksiyonu B class içinde override edilerek tekrardan düzenlendi

    val objC = C()
    objC.hashCode()
    println(objC) // burada C class'ının için toString fonksiyonu ezilerek(override) yeni işlev elde edildi.

    val baseA : Base = A(100) // Burada Base türünde bir A nesnesi oluşturduk. Yani Base'in A ile keşisen özelliklerini  kullanabiliriz.
    val baseA2 : A = A(100)  // Burada tüm A özelliklerini alabiliriz.

    val baseB : Base = B("New Title")
    val baseC : Base = C()
    

}
