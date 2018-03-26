package club.throwable.monitor.console.support.security

import club.throwable.monitor.console.common.ApplicationMonitorConstant
import club.throwable.monitor.console.configuration.MonitorConsoleProperties
import club.throwable.monitor.console.model.CurrentLoginUser
import club.throwable.monitor.console.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 14:58
 */
class ConsoleTokenInterceptor : HandlerInterceptorAdapter() {

    @Autowired
    private lateinit var monitorConsoleProperties: MonitorConsoleProperties

    companion object {
        private const val ERROR_MESSAGE_KEY = "error_message"
        private val uris: Array<String> = arrayOf("index", "login")
    }

    override fun preHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?): Boolean {
        val uri = request!!.requestURI
        for (value in uris) {
            if (uri.indexOf(value) != -1) {
                return true
            }
        }
        val loginUrl = String.format("%s/%s", request.contextPath, "index")
        val cookies = request.cookies
        if (null == cookies || cookies.isEmpty()) {
            request.setAttribute(ERROR_MESSAGE_KEY, "Illegal login status!!")
            request.getRequestDispatcher(loginUrl).forward(request, response)
            return false
        }
        for (cookie in cookies) {
            if (ApplicationMonitorConstant.TOKEN_NAME == cookie.name) {
                val cookieValue = cookie.value
                try {
                    val decryptToken = JwtUtils.decrypt(cookieValue, CurrentLoginUser::class.java)
                    if (monitorConsoleProperties.username == decryptToken.username
                            && monitorConsoleProperties.password == decryptToken.password) {
                        return true
                    }
                } catch (e: Exception) {
                    request.setAttribute(ERROR_MESSAGE_KEY, "Illegal login status!!")
                    request.getRequestDispatcher(loginUrl).forward(request, response)
                    return false
                }
            }
        }
        request.setAttribute(ERROR_MESSAGE_KEY, "Illegal login status!!")
        request.getRequestDispatcher(loginUrl).forward(request, response)
        return false
    }
}