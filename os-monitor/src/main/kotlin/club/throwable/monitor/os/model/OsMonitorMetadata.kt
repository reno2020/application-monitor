package club.throwable.monitor.os.model

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:11
 */
class OsMonitorMetadata(
        var osBasicInfo: OsBasicInfo? = null,
        var diskSpaceInfoList: List<DiskSpaceInfo>? = null,
        var physicalMemorySpaceInfo: PhysicalMemorySpaceInfo? = null,
        var virtualMachineInfo: VirtualMachineInfo? = null
)