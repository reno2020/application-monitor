package club.throwable.monitor.os.support

import club.throwable.monitor.os.model.DiskSpaceInfo
import java.io.File


/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:21
 */
class DiskSpaceInfoExtractor {

    fun extractDiskInfo(): List<DiskSpaceInfo> {
        val disks = File.listRoots()
        val infoList = ArrayList<DiskSpaceInfo>()
        disks.forEach {
            val info = DiskSpaceInfo(
                    it.totalSpace,
                    it.freeSpace,
                    it.usableSpace,
                    it.path
            )
            infoList.add(info)
        }
        return infoList
    }
}