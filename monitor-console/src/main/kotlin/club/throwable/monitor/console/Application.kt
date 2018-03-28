package club.throwable.monitor.console

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 16:07
 */
@SpringBootApplication
class Application : CommandLineRunner {

    @Bean(value = ["threadPool1"])
    fun threadPool1(): ThreadPoolExecutor {
        return ThreadPoolExecutor(5, 10, 0, TimeUnit.SECONDS,
                LinkedBlockingQueue(10))
    }

    @Bean(value = ["threadPool2"])
    fun threadPool2(): ThreadPoolExecutor {
        return ThreadPoolExecutor(10, 20, 0, TimeUnit.SECONDS,
                LinkedBlockingQueue(50))
    }

    override fun run(vararg args: String?) {
        for (i in 1..20) {
            threadPool1().execute({
                TimeUnit.SECONDS.sleep(10000)
            })
        }
    }
}

fun main(vararg args: String) {
    runApplication<Application>(* args)
}