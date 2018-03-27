package club.throwable.monitor.os.model

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:06
 */
class PhysicalMemorySpaceInfo(
        var totalPhysicalMemorySize: Long? = null,
        var freePhysicalMemorySize: Long? = null,
        var usablePhysicalMemorySize: Long? = null
)