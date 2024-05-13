package app.birojow.kotlindslexample

fun main() {

    val user = User(
        name = "Fulano",
        contactInfo = ContactInfo(
            email = "fulano@gmail.com",
            phoneNumber = "11991234567"
        ),
        roles = listOf(
            Role.User,
            Role.Admin
        )
    )

    val userWithDsl = user {
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
}