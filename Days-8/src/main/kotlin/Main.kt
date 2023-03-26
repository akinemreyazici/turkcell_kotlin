fun main(args: Array<String>) {

    var userCustomer: User = Customer(200,123456)
    println("Title : ${userCustomer.userName()} Total : ${userCustomer.userTotal()}")

    var productImpl = ProductImpl()
    /*
        productImpl.productAdd()
        productImpl.productList()
        productImpl.productSearch()
    */

    var product : IProduct = ProductImpl()
}