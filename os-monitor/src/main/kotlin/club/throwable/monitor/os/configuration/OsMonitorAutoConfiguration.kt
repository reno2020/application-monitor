package club.throwable.monitor.os.configuration

import club.throwable.monitor.os.support.DiskSpaceInfoExtractor
import club.throwable.monitor.os.support.OsBasicInfoExtractor
import club.throwable.monitor.os.support.PhysicalMemorySpaceInfoExtractor
import club.throwable.monitor.os.support.VirtualMachineInfoExtractor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/27 16:44
 */
@Configuration
class OsMonitorAutoConfiguration {

    @Bean
    fun osBasicInfoExtractor(): OsBasicInfoExtractor {
        return OsBasicInfoExtractor()
    }

    @Bean
    fun diskSpaceInfoExtractor(): DiskSpaceInfoExtractor {
        return DiskSpaceInfoExtractor()
    }

    @Bean
    fun physicalMemorySpaceInfoExtractor(): PhysicalMemorySpaceInfoExtractor {
        return PhysicalMemorySpaceInfoExtractor()
    }

    @Bean
    fun virtualMachineInfoExtractor(): VirtualMachineInfoExtractor {
        return VirtualMachineInfoExtractor()
    }
}