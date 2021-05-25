package com.springboot.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * Spring初始化测试
 */
@Component
@Slf4j
public class SpringLifeCycle implements InitializingBean, DisposableBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("初始化");
    }

    @Override
    public void destroy() throws Exception {
        log.info("销毁");
    }
}
