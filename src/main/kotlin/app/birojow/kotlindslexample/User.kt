package app.birojow.kotlindslexample

data class User(
    val name: String,
    val contactInfo: ContactInfo,
    val roles: List<Role>
)

data class ContactInfo(
    val email: String,
    val phoneNumber: String
)

enum class Role {
    User, Manager, Admin
}
