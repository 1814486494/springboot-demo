package com.springboot.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogRecordAop {

    @Pointcut("execution(* com.springboot.demo.controller.*.*(..))")
    private void pointCut(){}

//    @Around("@annotation(logRecord)")
//    private Object logRecord(ProceedingJoinPoint point, LogRecord logRecord){
//        logRecord.operating();
//        return null;
//    }
}
