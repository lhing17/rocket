package cn.gsein.common.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理跨域请求的拦截器，为response增加header
 *
 * @author G.Seinfeld
 * @date 2018/12/27
 */
public class CorsInterceptor implements HandlerInterceptor {

    private static final String ORIGIN = "Origin";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果request中不包含Origin字段，说明不是跨域请求
        if (StringUtils.isEmpty(request.getHeader(ORIGIN))) {
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        // 跨域请求默认不携带cookie，只有后端的response的header中将Access-Control-Allow-Credentials设置为true，
        // 且前端设置withCredentials为true时才会携带cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 如果要求前端携带cookie，header中Access-Control-Allow-Origin必须赋值，且不能赋值为*
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        return true;
    }
}
