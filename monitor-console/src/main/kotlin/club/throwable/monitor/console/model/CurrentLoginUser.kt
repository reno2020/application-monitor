package club.throwable.monitor.console.model

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 12:11
 */
class CurrentLoginUser {

    var username: String? = null
    var password: String? = null

    constructor()

    constructor(username: String, password: String) : this() {
        this.username = username
        this.password = password
    }

    override fun toString(): String {
        return "CurrentLoginUser(username=$username, password=$password)"
    }
}