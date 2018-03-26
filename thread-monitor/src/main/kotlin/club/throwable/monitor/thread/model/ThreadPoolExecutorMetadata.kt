package club.throwable.monitor.thread.model

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 11:13
 */
class ThreadPoolExecutorMetadata(
        var beanName: String? = null,
        var corePoolSize: Int? = null,
        var maximumPoolSize: Int? = null,
        var keepAliveSecond: Long? = null,
        var allowCoreThreadTimeOut: Boolean? = null,
        var rejectedExecutionPolicy: String? = null,
        var blockingTaskCount: Int? = null,
        var taskCount: Long? = null,
        var completedTaskCount: Long? = null,
        var activeCount: Int? = null,
        var largestPoolSize: Int? = null,
        var poolSize: Int? = null
)