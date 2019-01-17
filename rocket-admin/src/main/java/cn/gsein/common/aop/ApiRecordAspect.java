package cn.gsein.common.aop;

import cn.gsein.common.entity.ApiRecord;
import cn.gsein.common.mapper.ApiRecordMapper;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 记录API调用日志的切面
 *
 * @author G_Seinfeld
 * @date 2019/1/17
 */
@Component
@Aspect
public class ApiRecordAspect {

    private Logger logger = LoggerFactory.getLogger(ApiRecordAspect.class);

    private static final int MAX_RESULT_SIZE = 300;

    @Resource
    private ApiRecordMapper apiRecordMapper;

    /**
     * 记录API请求日志
     * @param point 切面的切入点
     * @param postMapping 切入方法的注解
     * @return 切入方法的返回结果
     */
    @Around("@annotation(postMapping)")
    public Object saveApiRecord(ProceedingJoinPoint point, PostMapping postMapping){
        return saveApiRecord(point);
    }

    /**
     * 记录API请求日志
     * @param point 切面的切入点
     * @param getMapping 切入方法的注解
     * @return 切入方法的返回结果
     */
    @Around("@annotation(getMapping)")
    public Object saveApiRecord(ProceedingJoinPoint point, GetMapping getMapping){
        return saveApiRecord(point);
    }

    /**
     * 记录API请求日志
     * @param point 切面的切入点
     * @param putMapping 切入方法的注解
     * @return 切入方法的返回结果
     */
    @Around("@annotation(putMapping)")
    public Object saveApiRecord(ProceedingJoinPoint point, PutMapping putMapping){
        return saveApiRecord(point);
    }

    /**
     * 记录API请求日志
     * @param point 切面的切入点
     * @param deleteMapping 切入方法的注解
     * @return 切入方法的返回结果
     */
    @Around("@annotation(deleteMapping)")
    public Object saveApiRecord(ProceedingJoinPoint point, DeleteMapping deleteMapping){
        return saveApiRecord(point);
    }

    private Object saveApiRecord(ProceedingJoinPoint point) {
        Object result = null;
        try {
            ApiRecord apiRecord = new ApiRecord();
            ServletRequestAttributes requestAttributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = requestAttributes.getRequest();
                Map<String, String[]> parameterMap = request.getParameterMap();
                apiRecord.setParams(JSONObject.toJSONString(parameterMap));
                MethodSignature methodSignature = (MethodSignature) point.getSignature();
                apiRecord.setName(methodSignature.getName());
            }
            result = point.proceed();

            String resultStr = JSONObject.toJSONString(result);
            if (resultStr.length() > MAX_RESULT_SIZE){
                resultStr = "";
            }
            apiRecord.setResult(resultStr);
            apiRecordMapper.save(apiRecord);
        } catch (Throwable throwable) {
            logger.error("记录API调用日志切面异常", throwable);
        }
        return result;
    }

}
