package club.throwable.monitor.os.support

import club.throwable.monitor.os.model.PhysicalMemorySpaceInfo
import com.sun.management.OperatingSystemMXBean
import java.lang.management.ManagementFactory


/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:30
 */
class PhysicalMemorySpaceInfoExtractor {

    fun extractPhysicalMemorySpaceInfo(): PhysicalMemorySpaceInfo {
        val mem = ManagementFactory.getOperatingSystemMXBean() as OperatingSystemMXBean
        val info = PhysicalMemorySpaceInfo()
        info.totalPhysicalMemorySize = mem.totalPhysicalMemorySize
        info.freePhysicalMemorySize = mem.freePhysicalMemorySize
        info.usablePhysicalMemorySize = mem.totalPhysicalMemorySize - mem.freePhysicalMemorySize
        return info
    }
}