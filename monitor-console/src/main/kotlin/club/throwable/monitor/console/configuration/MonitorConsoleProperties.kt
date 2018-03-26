package club.throwable.monitor.console.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 10:34
 */
@ConfigurationProperties(prefix = MonitorConsoleProperties.PREFIX)
class MonitorConsoleProperties(
        var username: String? = null,
        var password: String? = null
) {

    companion object {
        const val PREFIX = "application-monitor.console"
    }
}