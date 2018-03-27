package club.throwable.monitor.thread.web

import club.throwable.monitor.thread.model.BooleanResult
import club.throwable.monitor.thread.model.ThreadPoolExecutorMetadata
import club.throwable.monitor.thread.model.ThreadPoolExecutorUpdateVO
import club.throwable.monitor.thread.model.ThreadPoolInfo
import club.throwable.monitor.thread.support.ThreadMonitorManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 10:39
 */
@RestController
class ThreadMonitorController {

    @Autowired
    private lateinit var threadMonitorManager: ThreadMonitorManager

    @GetMapping(value = ["/monitor/thread/metadata/list"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun metadataList(): ResponseEntity<ThreadPoolInfo> {
        return ResponseEntity.ok(ThreadPoolInfo(threadMonitorManager.getAllMetadata()))
    }

    @GetMapping(value = ["/monitor/thread/metadata/single"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun metadataSingle(@RequestParam(value = "beanName") beanName: String): ResponseEntity<ThreadPoolExecutorMetadata> {
        return ResponseEntity.ok(threadMonitorManager.getMetadata(beanName))
    }

    @PostMapping(value = ["/monitor/thread/purge"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun purge(@RequestParam(name = "beanName") beanName: String): ResponseEntity<BooleanResult> {
        return ResponseEntity.ok(BooleanResult(threadMonitorManager.purgeTaskQueue(beanName)))
    }

    @PostMapping(value = ["/monitor/thread/update"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun update(@RequestBody updateVO: ThreadPoolExecutorUpdateVO): ResponseEntity<BooleanResult> {
        return ResponseEntity.ok(BooleanResult(threadMonitorManager.updateThreadPoolExecutor(updateVO)))
    }
}