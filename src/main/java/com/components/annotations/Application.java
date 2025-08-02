package com.components.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Customer customer = context.getBean("customer",Customer.class); // Default with class name
//        Bank bank = context.getBean(Bank.class);
//        System.out.println(bank);
    }
}
