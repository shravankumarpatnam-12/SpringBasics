package com.tight.coupling;

public class TightCouplingExample {
    public static void main(String[] args) {
        SavingsAccount savingsAccount=new SavingsAccount(123,100.00,"DEMO","Testing");
        Customer customer=new Customer("Raj","Kumar","demo@gmail.com",987654321,savingsAccount);
        System.out.println(customer);
        System.out.println(customer.equals(customer));

    }

}
