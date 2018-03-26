package club.throwable.monitor.thread.support

import club.throwable.monitor.thread.model.ThreadPoolExecutorMetadata
import club.throwable.monitor.thread.model.ThreadPoolExecutorUpdateVO
import org.springframework.util.ClassUtils
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 11:18
 */
class InMemoryThreadMonitorManager : ThreadMonitorManager {

    private val executorBeans = ConcurrentHashMap<String, ThreadPoolExecutor>()

    override fun registerThreadPoolExecutor(beanName: String, threadPoolExecutor: ThreadPoolExecutor) {
        synchronized(executorBeans) {
            executorBeans.putIfAbsent(beanName, threadPoolExecutor)
        }
    }

    override fun getAllMetadata(): List<ThreadPoolExecutorMetadata> {
        val metadataList = ArrayList<ThreadPoolExecutorMetadata>(executorBeans.values.size)
        synchronized(executorBeans) {
            executorBeans.forEach { key: String, value: ThreadPoolExecutor ->
                val metadata = ThreadPoolExecutorMetadata(
                        beanName = key,
                        corePoolSize = value.corePoolSize,
                        maximumPoolSize = value.maximumPoolSize,
                        keepAliveSecond = value.getKeepAliveTime(TimeUnit.SECONDS),
                        allowCoreThreadTimeOut = value.allowsCoreThreadTimeOut(),
                        rejectedExecutionPolicy = ClassUtils.getShortName(value.rejectedExecutionHandler.javaClass),
                        blockingTaskCount = value.queue.size,
                        taskCount = value.taskCount,
                        completedTaskCount = value.completedTaskCount,
                        activeCount = value.activeCount,
                        largestPoolSize = value.largestPoolSize,
                        poolSize = value.poolSize
                )
                metadataList.add(metadata)
            }
        }
        return metadataList
    }

    override fun getMetadata(beanName: String): ThreadPoolExecutorMetadata {
        synchronized(executorBeans) {
            val value = executorBeans[beanName]
            return ThreadPoolExecutorMetadata(
                    beanName = beanName,
                    corePoolSize = value!!.corePoolSize,
                    maximumPoolSize = value.maximumPoolSize,
                    keepAliveSecond = value.getKeepAliveTime(TimeUnit.SECONDS),
                    allowCoreThreadTimeOut = value.allowsCoreThreadTimeOut(),
                    rejectedExecutionPolicy = ClassUtils.getShortName(value.rejectedExecutionHandler.javaClass),
                    blockingTaskCount = value.queue.size,
                    taskCount = value.taskCount,
                    completedTaskCount = value.completedTaskCount,
                    activeCount = value.activeCount,
                    largestPoolSize = value.largestPoolSize,
                    poolSize = value.poolSize
            )
        }
    }

    override fun purgeTaskQueue(beanName: String): Boolean {
        synchronized(executorBeans) {
            val value = executorBeans[beanName]
            val taskQueue = value!!.queue
            taskQueue!!.clear()
            return true
        }
    }

    override fun updateThreadPoolExecutor(updateVO: ThreadPoolExecutorUpdateVO): Boolean {
        synchronized(executorBeans) {
            val value = executorBeans[updateVO.beanName]
            if (null != updateVO.corePoolSize && value!!.corePoolSize != updateVO.corePoolSize) {
                value.corePoolSize = updateVO.corePoolSize!!
            }
            if (null != updateVO.maximumPoolSize && value!!.maximumPoolSize != updateVO.maximumPoolSize) {
                value.maximumPoolSize = updateVO.maximumPoolSize!!
            }
            if (null != updateVO.keepAliveSecond && value!!.getKeepAliveTime(TimeUnit.SECONDS) != updateVO.keepAliveSecond) {
                value.setKeepAliveTime(updateVO.keepAliveSecond!!, TimeUnit.SECONDS)
            }
            if (null != updateVO.allowCoreThreadTimeOut && !value!!.allowsCoreThreadTimeOut() == updateVO.allowCoreThreadTimeOut) {
                value.allowCoreThreadTimeOut(updateVO.allowCoreThreadTimeOut!!)
            }
            return true
        }
    }
}