package club.throwable.monitor.console.configuration

import club.throwable.monitor.console.support.security.ConsoleTokenInterceptor
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 12:09
 */
@Configuration
@EnableConfigurationProperties(value = [MonitorConsoleProperties::class])
class MonitorConsoleAutoConfiguration {

    @Bean
    fun consoleTokenInterceptor(): ConsoleTokenInterceptor {
        return ConsoleTokenInterceptor()
    }

    @Bean
    fun monitorConsoleWebMvcConfigurer(): MonitorConsoleWebMvcConfigurer {
        return MonitorConsoleWebMvcConfigurer()
    }
}