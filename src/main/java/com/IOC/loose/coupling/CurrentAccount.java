package com.IOC.loose.coupling;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CurrentAccount implements Account {
    private int accountNumber;
    private String businessName;
    private double balance;
    private double overdraftLimit;
    private boolean isActive;
    private LocalDate openedDate;
    private double interestRate;

    public CurrentAccount(int accountNumber, String businessName, double balance,
                          double overdraftLimit, boolean isActive, LocalDate openedDate,double interestRate) {
        this.accountNumber = accountNumber;
        this.businessName = businessName;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
        this.isActive = isActive;
        this.openedDate = openedDate;
        this.interestRate = interestRate;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDate openedDate) {
        this.openedDate = openedDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CurrentAccount that)) return false;
        return accountNumber == that.accountNumber &&
                Double.compare(balance, that.balance) == 0 &&
                Double.compare(overdraftLimit, that.overdraftLimit) == 0
                && isActive == that.isActive &&
                Double.compare(interestRate, that.interestRate) == 0
                && Objects.equals(businessName, that.businessName)
                && Objects.equals(openedDate, that.openedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, businessName, balance, overdraftLimit, isActive, openedDate, interestRate);
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber=" + accountNumber +
                ", businessName='" + businessName + '\'' +
                ", balance=" + balance +
                ", overdraftLimit=" + overdraftLimit +
                ", isActive=" + isActive +
                ", openedDate=" + openedDate +
                ", interestRate=" + interestRate +
                '}';
    }

    @Override
    public void closeAccount() {
        isActive = false;
        this.balance=0;
        System.out.println("Current Account"+accountNumber+"closed");
    }

    @Override
    public void deposit(double amount) {
        if (isActive && amount > 0) {
            balance += amount;
            System.out.println("Current Account" +accountNumber + "deposited " + amount);
        }else{
            System.out.println("Current Account"+accountNumber + "deposited Failed" + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if(isActive && balance>0 && amount > 0 && balance + overdraftLimit >= amount) {
            balance-=amount;
            System.out.println("Withdraw Successfully "+amount);
            System.out.println("Remaining Balance: "+balance);
        }else{
            System.out.println("Withdraw Failed "+amount);
        }
    }
}
