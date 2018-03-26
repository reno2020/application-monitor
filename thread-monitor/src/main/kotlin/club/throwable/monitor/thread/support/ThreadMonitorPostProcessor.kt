package club.throwable.monitor.thread.support

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanPostProcessor
import java.util.concurrent.ThreadPoolExecutor

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 11:38
 */
class ThreadMonitorPostProcessor : BeanPostProcessor {

    @Autowired
    private lateinit var threadMonitorManager: ThreadMonitorManager

    override fun postProcessAfterInitialization(bean: Any?, beanName: String?): Any {
        if (bean is ThreadPoolExecutor) {
            threadMonitorManager.registerThreadPoolExecutor(beanName!!, bean)
        }
        return bean!!
    }
}