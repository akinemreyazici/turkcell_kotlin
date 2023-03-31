class BaseImpl : IBase {
    override fun security(string: String): Boolean {
        if (string == "Ali") {
            return true
        }
        else {
            return false
        }
    }

    override fun token(token: String): Boolean {
        if (token == "token_1234")
            return true
        else
            return false
    }
}