package club.throwable.monitor.os.model

/**
 * @author throwable
 * @version v1.0
 * @description 磁盘信息
 * @since 2018/3/27 16:03
 */
class DiskSpaceInfo(
        var totalSpace: Long? = null,
        var freeSpace: Long? = null,
        var usableSpace: Long? = null,
        var path: String? = null
)