package com.johnny.vis.cloud.article.aop;

import com.johnny.vis.cloud.article.entity.LogEntity;
import com.johnny.vis.cloud.article.service.LogService;
import com.johnny.vis.cloud.article.util.HttpKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Johnny
 * @date 2020-12-25
 */
@Component
@Aspect
public class LogAop {
    /**
     * TODO 添加userCode
     */

    /**
     * AOP本身默认为单例模式 每次LogEntity不刷新
     * 因此是由ThreadLocal确保每次进入announce为新的entity实例
     */
    private static final ThreadLocal<LogEntity> LT = new ThreadLocal<>();

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void webLog() {
    }

    /**
     * 设置操作异常切入点记录异常日志 扫描所有controller包下操作
     */
    @Before(value = "webLog()")
    public void deBefore(JoinPoint joinPoint) {
        LogEntity logEntity = new LogEntity();
        LT.set(logEntity);
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        Api api = method.getDeclaringClass().getAnnotation(Api.class);
        if (null != api) {
            logEntity.setModuleName(api.value());
        }
        if (null != apiOperation) {
            logEntity.setLogName(apiOperation.value());
            logEntity.setRmk(apiOperation.notes());
        }
        logEntity.setPath(HttpKit.getRequest().getRequestURI());
        logEntity.setClassName(joinPoint.getTarget().getClass().getName());
        logEntity.setMethodName(joinPoint.getTarget().getClass().getName() + "." + method.getName());
        logEntity.setIp(HttpKit.getIp());
    }


    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            long beginTime = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            LogEntity logEntity = LT.get();
            logEntity.setSucceed("Y");
            logEntity.setStartTime(new Date(beginTime));
            logEntity.setOptTime(endTime - beginTime);
            logService.save(logEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @AfterThrowing(pointcut = "webLog()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        LogEntity logEntity = LT.get();
        long beginTime = System.currentTimeMillis();
        logEntity.setSucceed("N");
        logEntity.setStartTime(new Date(beginTime));
        logService.save(logEntity);
    }
}

