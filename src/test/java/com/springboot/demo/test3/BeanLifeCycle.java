package com.springboot.demo.test3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Spring初始化测试
 */
@Component
@Slf4j
public class BeanLifeCycle implements InitializingBean, DisposableBean {

//    @PostConstruct
//    public void start(){
//        log.info("bean创建");
//    }
//
//    @PreDestroy
//    public void destroy(){
//        log.info("bean销毁");
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("初始化");
    }

    @Override
    public void destroy() throws Exception {
        log.info("销毁");
    }
}
