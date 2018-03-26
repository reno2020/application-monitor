package club.throwable.monitor.console

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 16:07
 */
@SpringBootApplication
class Application

fun main(vararg args: String) {
    runApplication<Application>(* args)
}