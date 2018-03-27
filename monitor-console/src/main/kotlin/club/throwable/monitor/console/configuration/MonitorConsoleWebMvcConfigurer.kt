package club.throwable.monitor.console.configuration

import club.throwable.monitor.console.support.security.ConsoleTokenInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 15:46
 */
class MonitorConsoleWebMvcConfigurer : WebMvcConfigurer {

//    @Autowired
//    private lateinit var consoleTokenInterceptor: ConsoleTokenInterceptor
//
//    override fun addInterceptors(registry: InterceptorRegistry?) {
//        registry!!.addInterceptor(consoleTokenInterceptor).addPathPatterns("/**")
//        super.addInterceptors(registry)
//    }
}