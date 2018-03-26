package club.throwable.monitor.console.utils

import club.throwable.monitor.console.exception.JwtEncryptionException
import club.throwable.monitor.console.exception.JwtExpirationException
import club.throwable.monitor.console.exception.JwtVerificationException
import club.throwable.monitor.console.model.CurrentLoginUser
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.TokenExpiredException
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 12:24
 */
object JwtUtils {

    private const val SECRET = "XX#\$%()(#*!()!KL<><MQLM24dNQJQKqmsadjsdfkjsdrow32234545fdf>?N<:{LWPW"
    private const val EXPIRE_TIME = 60L * 60L * 1000L * 30L

    private var MAPPER = ObjectMapper()

    init {

    }

    fun <T> encrypt(value: T): String {
        return encrypt(value, EXPIRE_TIME)
    }

    fun <T> encrypt(value: T, expireTime: Long): String {
        try {
            val algorithm = Algorithm.HMAC256(SECRET)
            return JWT.create()
                    .withSubject(MAPPER.writeValueAsString(value))
                    .withIssuer("doge")
                    .withExpiresAt(Date(System.currentTimeMillis() + expireTime))
                    .sign(algorithm)
        } catch (e: Exception) {
            throw JwtEncryptionException(e)
        }
    }

    fun <T> decrypt(token: String, clazz: Class<T>): T {
        try {
            val algorithm = Algorithm.HMAC256(SECRET)
            val verifier = JWT.require(algorithm).withIssuer("doge").build()
            val decodedToken = verifier.verify(token)
            return MAPPER.readValue(decodedToken.subject, clazz)
        } catch (e: Exception) {
            if (e is TokenExpiredException) {
                throw JwtExpirationException(e.message!!)
            } else {
                throw JwtVerificationException(e)
            }
        }
    }
}

fun main(vararg arg: String) {
    val user = CurrentLoginUser("doge", "123456")
    val token = JwtUtils.encrypt(user)
    println(token)
    TimeUnit.SECONDS.sleep(2)
    val decrypt = JwtUtils.decrypt(token, CurrentLoginUser::class.java)
    println(decrypt)
}