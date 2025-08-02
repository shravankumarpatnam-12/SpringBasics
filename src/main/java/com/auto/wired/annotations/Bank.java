package com.auto.wired.annotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bank {
    @Autowired
    @Qualifier("customer")
    private Customer customer;
//    @Autowired
//    public Bank(Customer customer) {
//        this.customer = customer;
//    }

    @Override
    public String toString() {
        return "Bank{" +
                "customer=" + customer +
                '}';
    }
}
