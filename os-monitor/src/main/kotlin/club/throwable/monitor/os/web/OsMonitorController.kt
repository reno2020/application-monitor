package club.throwable.monitor.os.web

import club.throwable.monitor.os.model.OsMonitorMetadata
import club.throwable.monitor.os.support.DiskSpaceInfoExtractor
import club.throwable.monitor.os.support.OsBasicInfoExtractor
import club.throwable.monitor.os.support.PhysicalMemorySpaceInfoExtractor
import club.throwable.monitor.os.support.VirtualMachineInfoExtractor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 10:51
 */
@RestController
class OsMonitorController {

    @Autowired
    private lateinit var osBasicInfoExtractor: OsBasicInfoExtractor

    @Autowired
    private lateinit var diskSpaceInfoExtractor: DiskSpaceInfoExtractor

    @Autowired
    private lateinit var physicalMemorySpaceInfoExtractor: PhysicalMemorySpaceInfoExtractor

    @Autowired
    private lateinit var virtualMachineInfoExtractor: VirtualMachineInfoExtractor

    @GetMapping(value = ["/monitor/os"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun os(): ResponseEntity<OsMonitorMetadata> {
        return ResponseEntity.ok(OsMonitorMetadata(
                osBasicInfo = osBasicInfoExtractor.extractOsBasicInfo(),
                diskSpaceInfoList = diskSpaceInfoExtractor.extractDiskInfo(),
                physicalMemorySpaceInfo = physicalMemorySpaceInfoExtractor.extractPhysicalMemorySpaceInfo(),
                virtualMachineInfo = virtualMachineInfoExtractor.extractVirtualMachineInfo()
        ))
    }
}