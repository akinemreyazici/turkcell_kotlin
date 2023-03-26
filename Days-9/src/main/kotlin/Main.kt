import models.CategoryModel
import models.ProductModel
import user.Profile //Başka bir

fun main(args: Array<String>) {


    // var ac1 = Action() -> Private olduğundan burada çağıramayız. Kendi dosyasının içinde çağırabiliriz.
    var B = B()
    B.call()
    B.fncCall() // Burada A da tanımlanmış olduğundan fonksiyon aracılığıyla çekebildik.

    var profile = Profile()
    profile.adress
    profile.code // Main paketi ana paket olduğundan internal da görebiliriz.

    val c1 = CategoryModel(10,"Elektronik")
    val c2 = CategoryModel(11,"Ev")
    val c3 = CategoryModel(12,"Telefon")


    var p1 = ProductModel("TV",30000,c1)
    // println("${p1.title} ${p1.price}")

    val list = mutableListOf<ProductModel>()
    var p2 = ProductModel("Headset",1000,c1)
    var p3 = ProductModel("Tablet",15000,c1)
    var p4 = ProductModel("Table",4400,c2)
    var p5 = ProductModel("Phone",3300,c3)
    list.add(p1)
    list.add(p2)
    list.add(p3)
    list.add(p4)
    list.add(p5)

    for (item: ProductModel in list)
    {
        println("${item.title} -> ${item.price} -> ${item.category.name}")
    }

}