package com.springboot.demo.aop;

import com.springboot.demo.common.CommonResult;
import com.springboot.demo.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:linwenfeng
 * @Time:2020/10/28 11:06
 */
@Aspect
@Component
@Slf4j
public class ExceptionAop {

    //连接点
    @Pointcut("execution(* com.springboot.demo.controller.*.*(..))")
    private void pointCut(){}

    //异常信息提示
//    @AfterThrowing(pointcut = "pointCut()",throwing = "e")
//    private Object exceptionCatch(JoinPoint joinPoint, Exception e) throws Exception {
//        StackTraceElement stackTraceElement = e.getStackTrace()[0];
//        Map map = new HashMap();
//        map.put("异常：",e.getMessage());
//        map.put("异常所在类：",stackTraceElement.getClassName());
//        map.put("异常所在行数：",stackTraceElement.getLineNumber());
//        map.put("异常所在方法：",stackTraceElement.getMethodName());
//        log.info("异常："+e.getMessage());
//        log.info("异常所在类："+stackTraceElement.getClassName());
//        log.info("异常所在行数："+stackTraceElement.getLineNumber());
//        log.info("异常所在方法："+stackTraceElement.getMethodName());
//        if (e instanceof LoginException){
//            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(CommonResult.fail());
//        }
//        return null;
//    }

    //异常捕获处理
//    @Around("pointCut()")
//    public CommonResult exceptionProcess(ProceedingJoinPoint joinPoint) {
//        CommonResult data = null;
//        try {
//            //获取方法执行结果
//            data = (CommonResult) joinPoint.proceed();
//        } catch (Throwable throwable) {
//            StackTraceElement stackTraceElement = throwable.getStackTrace()[0];
//            log.info("异常："+throwable.getClass().getName()+" 详细信息："+throwable.getMessage());
//            log.info("异常所在类："+stackTraceElement.getClassName());
//            log.info("异常所在行数："+stackTraceElement.getLineNumber());
//            log.info("异常所在方法："+stackTraceElement.getMethodName());
//            return returnMsg(throwable,data);
//        }
//        return data;
//    }

    //自定义发生异常时返回的信息
    private <T> CommonResult returnMsg(Throwable throwable,T data){
        if (throwable instanceof LoginException){
            return CommonResult.fail("登录异常",data);
        }else {
            return CommonResult.fail("服务器端出现问题",data);
        }
    }

}
