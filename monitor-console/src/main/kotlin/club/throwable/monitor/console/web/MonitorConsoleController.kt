package club.throwable.monitor.console.web

import club.throwable.monitor.console.common.ApplicationMonitorConstant
import club.throwable.monitor.console.configuration.MonitorConsoleProperties
import club.throwable.monitor.console.model.CurrentLoginUser
import club.throwable.monitor.console.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.util.ClassUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2018/3/26 10:37
 */
@Controller
class MonitorConsoleController {

    companion object {
        val OPEN_THREAD_MONITOR = ClassUtils.isPresent(ApplicationMonitorConstant.THREAD_MONITOR_CONTORLLER, null)
        val OPEN_OS_MONITOR = ClassUtils.isPresent(ApplicationMonitorConstant.OS_MONITOR_CONTORLLER, null)
    }

    @Autowired
    private lateinit var monitorConsoleProperties: MonitorConsoleProperties

    @GetMapping(value = ["/index"])
    fun loginView(): ModelAndView {
        val mav = ModelAndView()
        mav.viewName = "login"
        return mav
    }

    @PostMapping(value = ["/login"])
    fun login(@RequestParam(value = "username") username: String,
              @RequestParam(value = "password") password: String,
              response: HttpServletResponse): ModelAndView {
        val mav = ModelAndView()
        if (monitorConsoleProperties.username == username && monitorConsoleProperties.password == password) {
            val cookie = Cookie(ApplicationMonitorConstant.TOKEN_NAME, JwtUtils.encrypt(CurrentLoginUser(username, password)))
            response.addCookie(cookie)
            mav.viewName = "console"
        } else {
            mav.viewName = "login"
            mav.addObject("error_message", "username or password error!!")
        }
        return mav
    }

    @GetMapping(value = ["/logout"])
    fun logout(request: HttpServletRequest): ModelAndView {
        val mav = ModelAndView()
        val cookies = request.cookies
        if (null != cookies && !cookies.isEmpty()) {
            for (cookie in cookies) {
                if (ApplicationMonitorConstant.TOKEN_NAME == cookie.name) {
                    cookie.maxAge = 0
                }
            }
        }
        mav.viewName = "login"
        return mav
    }

    @GetMapping(value = ["/console"])
    fun console(): ModelAndView {
        val mav = ModelAndView()
        mav.addObject("OPEN_THREAD_MONITOR", OPEN_THREAD_MONITOR)
        mav.addObject("OPEN_OS_MONITOR", OPEN_OS_MONITOR)
        mav.viewName = "console"
        return mav
    }
}