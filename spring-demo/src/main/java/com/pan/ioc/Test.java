package com.pan.ioc;

import com.pan.configuration.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        DataConfig dataConfig = new DataConfig();
//        dataConfig.setDriverName("Driver");
//        dataConfig.setUrl("localhost:3306/dbname");
//        dataConfig.setDriverName("root");
//        dataConfig.setPassword("root");
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        System.out.println(context.getBean("config"));

//        ApplicationContext context = new AnnotationConfigApplicationContext("com.pan.configuration");
//        System.out.println(context.getBean("config"));

        ApplicationContext context = new AnnotationConfigApplicationContext("com.pan.ioc");
        System.out.println(context.getBean(GlobalConfig.class));
    }
}
