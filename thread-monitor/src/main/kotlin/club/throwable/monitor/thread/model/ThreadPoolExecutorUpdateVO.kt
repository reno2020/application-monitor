package club.throwable.monitor.thread.model

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 11:15
 */
class ThreadPoolExecutorUpdateVO(
        var beanName: String? = null,
        var corePoolSize: Int? = null,
        var maximumPoolSize: Int? = null,
        var keepAliveSecond: Long? = null,
        var allowCoreThreadTimeOut: Boolean? = null
)