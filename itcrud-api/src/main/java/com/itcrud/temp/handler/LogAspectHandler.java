package com.itcrud.temp.handler;

import com.alibaba.fastjson.JSON;
import com.itcurd.temp.constant.Constants;
import com.itcurd.temp.enums.BizCodeEnum;
import com.itcurd.temp.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Author: Joker
 * @Desc: 统一切面，输出请求入参+出参+业务处理时间
 * @Date: 2018/12/7 14:06
 * @Modified By:
 * @Project_name: itcrud-commons
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspectHandler {

    @Pointcut("execution(* com.itcrud.temp..*Controller.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        RequestAttributes attr = RequestContextHolder.getRequestAttributes();
        String requestId = Constants.REQUEST_ID_DEFAULT;
        if (attr != null) {
            HttpServletRequest request = ((ServletRequestAttributes) attr).getRequest();
            requestId = request.getHeader(Constants.REQUEST_ID);
            if (StringUtils.isBlank(requestId)) throw new BizException(BizCodeEnum.CODE_500001);
        }
        MDC.put(Constants.REQUEST_ID, requestId);
        //请求方法信息
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        StringBuilder logStr = new StringBuilder();
        try {
            logStr.append("请求方法：").append(joinPoint.getTarget().getClass().getName())
                    .append(".").append(method.getName()).append("()");
            //组装请求参数
            Parameter[] parameters = method.getParameters();
            Object[] args = joinPoint.getArgs();
            String[] parameterNames = ms.getParameterNames();
            StringBuilder params = new StringBuilder(" 请求参数：");
            for (int i = 0; i < parameters.length; i++) {
                params.append(parameterNames[i]).append(":").append(args[i]).append(";");
            }
            logStr.append(params.substring(0, params.length() - 1));//去掉最后的";"
            //记录业务执行时间
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Object result = joinPoint.proceed();//执行业务逻辑
            stopWatch.stop();
            logStr.append(" 执行耗时：").append(stopWatch.getTotalTimeMillis()).append("ms");
            logStr.append(" 响应数据：").append(JSON.toJSONString(result));
            return result;
        } finally {
            log.info(logStr.toString());
        }
    }
}
