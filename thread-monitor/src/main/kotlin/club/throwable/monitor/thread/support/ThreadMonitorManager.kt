package club.throwable.monitor.thread.support

import club.throwable.monitor.thread.model.ThreadPoolExecutorMetadata
import club.throwable.monitor.thread.model.ThreadPoolExecutorUpdateVO
import java.util.concurrent.ThreadPoolExecutor

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 11:16
 */
interface ThreadMonitorManager {

    fun registerThreadPoolExecutor(beanName: String, threadPoolExecutor: ThreadPoolExecutor)

    fun getAllMetadata(): List<ThreadPoolExecutorMetadata>

    fun getMetadata(beanName: String): ThreadPoolExecutorMetadata

    fun purgeTaskQueue(beanName: String): Boolean

    fun updateThreadPoolExecutor(updateVO: ThreadPoolExecutorUpdateVO): Boolean
}