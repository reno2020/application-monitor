package club.throwable.monitor.os.support

import club.throwable.monitor.os.model.VirtualMachineInfo

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:35
 */
class VirtualMachineInfoExtractor {

    fun extractVirtualMachineInfo():VirtualMachineInfo{
        val runtime = Runtime.getRuntime()
        val info = VirtualMachineInfo()

        return info
    }
}