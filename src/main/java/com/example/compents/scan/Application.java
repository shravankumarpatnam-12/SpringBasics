package com.example.compents.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationComponentsScan.xml");
        //Customer customer = context.getBean("customer",Customer.class); // Default with class name
        Customer customer = context.getBean("customer1",Customer.class);
        System.out.println(customer.toString());
    }
}
