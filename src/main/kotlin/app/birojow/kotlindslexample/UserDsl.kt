package app.birojow.kotlindslexample

fun user(init: UserDsl.() -> Unit): User {
    return UserDsl().apply(init).build()
}

@UserDslScope
class UserDsl {
    lateinit var name: String
    private val contactInfoDsl = UserContactInfoDsl()
    private val rolesDsl = UserRolesDsl()

    fun contactInfo(init: UserContactInfoDsl.() -> Unit) {
        contactInfoDsl.apply(init)
    }

    fun roles(init: UserRolesDsl.() -> Unit) {
        rolesDsl.apply(init)
    }

    fun build(): User {
        return User(
            name = name,
            contactInfo = ContactInfo(
                email = contactInfoDsl.email,
                phoneNumber = contactInfoDsl.phoneNumber
            ),
            roles = rolesDsl.roles
        )
    }

    @UserDslScope
    class UserContactInfoDsl {
        lateinit var email: String
        lateinit var phoneNumber: String
    }

    @UserDslScope
    class UserRolesDsl {
       lateinit var roles: MutableList<Role>

        operator fun Role.unaryPlus() {
            if (!this@UserRolesDsl::roles.isInitialized) {
                this@UserRolesDsl.roles = mutableListOf()
            }
            roles.add(this)
        }
    }
}

@DslMarker
annotation class UserDslScope
