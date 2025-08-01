package com.loose.coupling;

import java.time.LocalDate;

public class LooseCouplingExample {
    public static void main(String[] args) {
        Account savingAccount=new SavingsAccount(10001,1000.00,3.50,
                LocalDate.of(2024, 8, 1),true);
        Account currentAccount=new CurrentAccount(10002,"Demo",500.00,
                1000.00,true,LocalDate.of(2024, 8, 1),3.30);
        Account fixedDeposit=new FixedDeposit(10003,10000.00,3.50,
                120,LocalDate.of(2024, 8, 1),LocalDate.of(2034, 8, 1),
                true,true);
        Account salaryAccount=new SalaryAccount(10004,100001,"Name",6.50,
                2500.00,true,LocalDate.of(2024, 8, 1),
                LocalDate.of(2024, 8, 1),true);
        Account nriAccount= new NRIAccount(10005,"NRE","USA",500000,
                4.5,"USD",LocalDate.of(2024, 8, 1),true);

        Customer customer1=new Customer("Raj","Kumar","Raj@gmail.com","987654321",savingAccount);
        savingAccount.deposit(500);
        savingAccount.withdraw(1000);
        savingAccount.calculateInterest();
        customer1.toString();
        Customer customer2=new Customer("John","Smith","john@gmail.com","0487651235",currentAccount);
        customer2.toString();
        Customer customer3=new Customer("Ian","Bell","ian@gmail.com","08763436753",fixedDeposit);
        customer3.toString();
        Customer customer4=new Customer("Joe","Root","joe@gmail.com","0787428231",salaryAccount);
        customer4.toString();
        Customer customer5=new Customer("Greme","Smith","smith@gmail.com","038538523",nriAccount);
        customer5.toString();


    }

}
