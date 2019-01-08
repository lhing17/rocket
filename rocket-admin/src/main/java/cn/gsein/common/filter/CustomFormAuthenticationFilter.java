package cn.gsein.common.filter;

import cn.gsein.common.util.HttpUtil;
import cn.gsein.system.entity.JsonResult;
import cn.gsein.system.utils.ReturnCode;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义表单验证过滤器，对应authc
 *
 * @author G.Seinfeld
 * @date 2019/1/2
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 在访问controller前判断是否登录，返回json，不进行重定向。
     *
     * @param request  请求对象
     * @param response 响应对象
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (request instanceof HttpServletRequest && logger.isInfoEnabled()) {
            logger.info(HttpUtil.getIpAddr((HttpServletRequest) request) + "访问拒绝：用户未登录");
        }

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");

        JsonResult jsonResult = JsonResult.error(ReturnCode.NOT_LOGGING_IN);
        httpServletResponse.getWriter().write(JSONObject.toJSON(jsonResult).toString());
        return false;
    }
}
