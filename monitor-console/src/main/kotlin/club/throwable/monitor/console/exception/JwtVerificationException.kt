package club.throwable.monitor.console.exception

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 14:25
 */
class JwtVerificationException(val throwable: Throwable) : RuntimeException()