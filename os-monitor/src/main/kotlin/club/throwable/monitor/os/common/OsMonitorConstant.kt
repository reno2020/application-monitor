package club.throwable.monitor.os.common

/**
 * @author throwable
 * @version v1.0
 * @since 2018/3/27 21:58
 * @description
 */
class OsMonitorConstant {

    companion object {
        const val DISK_THRESHOLD = 500L * 1024L * 1024L
        const val MEMORY_THRESHOLD = 100L * 1024L * 1024L
    }
}