package app.birojow.kotlindslexample

data class User(
    val name: String,
    val contactInfo: ContactInfo,
    val roles: List<Role>
)
