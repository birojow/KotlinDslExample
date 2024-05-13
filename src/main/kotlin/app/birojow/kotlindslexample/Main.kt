package app.birojow.kotlindslexample

fun main() {

    val user = user {
        name = "Fulano"
        contactInfo {
            email = "fulano@gmail.com"
            phoneNumber = "11991234567"
        }
        roles {
            +Role.User
            +Role.Admin
        }
    }

    println(user)
}
