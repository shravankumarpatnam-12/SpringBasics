package com.auto.wire.loose.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireExample {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationAutoWireContext.xml");
        Customer customer = (Customer)applicationContext.getBean("customerBean");
        System.out.println(customer);
//        Customer customer1 = (Customer)applicationContext.getBean("customerBean1");
//        System.out.println(customer1);
//        Customer customer2 = (Customer)applicationContext.getBean("customerBean2");
//        System.out.println(customer2);
    }
}
