package com.sapient.models;

import com.sapient.utility.ApplicationContextApp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Vehicle implements BeanNameAware, BeanClassLoaderAware {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextApp.class);
    private String regNo;
    private String make;
    private String color;
    private long cost;
    private Date dop;


    @Override
    public void setBeanName(String s) {
        logger.info("Bean Aware"+s);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("BeanClassLoader"+ classLoader.getName());
    }
    @PostConstruct
    public void customInit(){
        logger.info("invoking custom init......");
    }

    @PreDestroy
    public void beforeDestroy(){
        logger.info("before destroy......");
    }

}
