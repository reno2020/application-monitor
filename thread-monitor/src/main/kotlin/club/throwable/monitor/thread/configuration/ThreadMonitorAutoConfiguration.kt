package club.throwable.monitor.thread.configuration

import club.throwable.monitor.thread.support.InMemoryThreadMonitorManager
import club.throwable.monitor.thread.support.ThreadMonitorManager
import club.throwable.monitor.thread.support.ThreadMonitorPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 11:11
 */
@Configuration
class ThreadMonitorAutoConfiguration {

    @Bean
    fun threadMonitorManager(): ThreadMonitorManager{
        return InMemoryThreadMonitorManager()
    }

    @Bean
    fun threadMonitorPostProcessor(): ThreadMonitorPostProcessor{
        return ThreadMonitorPostProcessor()
    }
}