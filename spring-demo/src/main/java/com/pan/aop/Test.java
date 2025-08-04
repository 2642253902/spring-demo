package com.pan.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Cal bean = context.getBean(Cal.class);
        System.out.println(bean.add(1, 3));
        System.out.println(bean.sub(1, 3));
        System.out.println(bean.mul(1, 3));
        System.out.println(bean.div(1, 3));


    }

}
