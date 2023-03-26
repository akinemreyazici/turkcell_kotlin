interface IProduct {

    fun productAdd(title : String, price : Int) : Boolean
    fun productList() : List<String>
    fun productSearch(data : String) : List<String>

    /* Interfaceleri şablon için kullanırız. Fonksiyonlarımız hangi değerleri alıp hangi değerleri döndüreceğini
    daha düzenli ve anlaşılabilir olması için kullanıyoruz. */

}