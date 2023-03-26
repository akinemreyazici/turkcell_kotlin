class Customer (private val number : Int,private var TCNumber : Int = 0) : User() {

    override fun userNumber(): Int {
        return this.number

    }

    override fun userTC(): Int {
        return this.TCNumber
    }
}