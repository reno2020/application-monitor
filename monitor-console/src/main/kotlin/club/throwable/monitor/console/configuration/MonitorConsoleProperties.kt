package club.throwable.monitor.console.configuration

import club.throwable.monitor.os.common.OsMonitorConstant
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 10:34
 */
@ConfigurationProperties(prefix = MonitorConsoleProperties.PREFIX)
class MonitorConsoleProperties(
        var username: String = IDENTITY,
        var password: String = IDENTITY,
        var diskThreshold: Long = DISK_THRESHOLD,
        var memoryThreshold: Long = MEMORY_THRESHOLD
) {

    companion object {
        const val IDENTITY = "admin"
        const val PREFIX = "throwable-monitor.console"
        const val DISK_THRESHOLD = OsMonitorConstant.DISK_THRESHOLD
        const val MEMORY_THRESHOLD = OsMonitorConstant.MEMORY_THRESHOLD
    }
}