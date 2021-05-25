package com.springboot.demo.aop;

import com.springboot.demo.bean.Token;
import com.springboot.demo.common.CommonResult;
import com.springboot.demo.exception.LoginException;
import com.springboot.demo.util.DateUtil;
import com.springboot.demo.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author:linwenfeng
 * @Time:2020/10/24 13:50
 */
@Aspect
@Component
@Slf4j
public class LoginMonitorAop {

    @Pointcut("execution(* com.springboot.demo.controller.*.*(..))")
    private void before(){}

    @Pointcut("@within(com.springboot.demo.annotation.LoginCheckAnnotation) || @annotation(com.springboot.demo.annotation.LoginCheckAnnotation)")
    private void loginAnnotation(){}

//    @Before("before()")
//    private void loginIntercept(JoinPoint joinPoint) throws NoSuchMethodException {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        Class<?> aClass = joinPoint.getTarget().getClass();
//        boolean classAnnotation = aClass.isAnnotationPresent(LoginCheckAnnotation.class);
//        if (classAnnotation){
//            assert requestAttributes != null;
////            System.out.println("登录拦截");
//            String token = requestAttributes.getRequest().getHeader("token");
//            System.out.println(token+": "+token);
//            judgment(token);
//        }else {
//            Signature signature = joinPoint.getSignature();
//            Method method = aClass.getMethod(signature.getName(), ((MethodSignature) signature).getMethod().getParameterTypes());
//            boolean methodAnnotation = method.isAnnotationPresent(LoginCheckAnnotation.class);
//            if (methodAnnotation){
////                System.out.println("方法登录拦截");
//                String token = requestAttributes.getRequest().getHeader("token");
//                System.out.println(token+": "+token);
//                judgment(token);
//            }
//        }
//    }

    @Around("loginAnnotation()")
    private CommonResult loginCatch(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert request != null;
        HttpServletRequest req = request.getRequest();
        String token = null;
        try {
            token = req.getHeader("token");
        } catch (Exception e) {
            throw new LoginException("need login");
        }
        CommonResult<Object> proceed = (CommonResult)point.proceed();
        //先判断token是否为空
        if (tokenJudgment(token)){
            //不为空取得过期时间
            long expireTimeStamp = Long.parseLong(req.getHeader("expireTimeStamp"));
            //再判断token是否过期
            if (checkTime(expireTimeStamp)){
                //token过期取得刷新token
                String refreshToken = req.getHeader("refreshToken");
                //判断刷新token是否为空
                if (tokenJudgment(refreshToken)){
                    try {
                        //通过刷新token取得账号等信息，如果报错直接返回登录
                        JWTUtil jwtUtil = new JWTUtil(refreshToken);
                        String account = jwtUtil.getAccount();
                        //生成新token
                        String newToken = JWTUtil.generateToken(account);
                        String newRefreshToken = JWTUtil.generateRefreshToken(account);
                        long newExpireTime = new Date().getTime()+900000;
                        proceed.setToken(new Token(newToken,newRefreshToken,newExpireTime));
                        log.info("刷新账号: "+account);
                        log.info("过期时间: "+ DateUtil.dateFormat(new Date(newExpireTime)));
                        return proceed;
                    } catch (Exception e) {
                        throw new LoginException("need login");
                    }
                } else {
                    throw new LoginException("need login");
                }
            }else {
                JWTUtil jwtUtil = new JWTUtil(token);
                String account = jwtUtil.getAccount();
                log.info("登录账号: "+account);
                log.info("过期时间: "+ DateUtil.dateFormat(new Date(expireTimeStamp)));
                return proceed;
            }
        }else {
            throw new LoginException("need login");
        }
    }

    private boolean tokenJudgment(String token){
        return token != null && token.trim().length() != 0;
    }

    private boolean checkTime(Long expireTimeStamp){
        return new Date(expireTimeStamp).before(new Date());
    }

}
