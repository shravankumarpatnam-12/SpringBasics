package com.example.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationStart {
     public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationBeanContext.xml");
        BeanExample bean=(BeanExample)app.getBean("firstBeanExample");
        System.out.println(bean);
     }
}
