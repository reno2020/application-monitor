package club.throwable.monitor.os.support

import club.throwable.monitor.os.model.OsBasicInfo

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:33
 */
class OsBasicInfoExtractor {

    fun extractOsBasicInfo(): OsBasicInfo {
        val runtime = Runtime.getRuntime()
        val info = OsBasicInfo()
        info.processorNumber = runtime.availableProcessors()
        return info
    }
}