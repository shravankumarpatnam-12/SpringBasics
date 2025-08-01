package com.loose.coupling;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class SavingsAccount implements Account {
    private int accountNumber;
    private double balance;
    private double interestRate;
    private LocalDate openedDate;
    private boolean isActive;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, double balance, double interestRate,
                          LocalDate openedDate, boolean isActive) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
        this.openedDate = openedDate;
        this.isActive = isActive;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(LocalDate openedDate) {
        this.openedDate = openedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SavingsAccount that)) return false;
        return accountNumber == that.accountNumber && Double.compare(balance, that.balance) == 0 && Double.compare(interestRate, that.interestRate) == 0 && isActive == that.isActive && Objects.equals(openedDate, that.openedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, interestRate, openedDate, isActive);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", openedDate=" + openedDate +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public void calculateInterest() {
        if (isActive) {
         LocalDate today = LocalDate.now();
         long monthsBetween = ChronoUnit.MONTHS.between(openedDate, today);
         double interestAmount=(balance*interestRate*monthsBetween)/(100*12);
         balance=balance-interestAmount;
         System.out.println("Calculated interest amount "+interestAmount);
         System.out.println("balance "+balance);
        }else{
            System.out.println("Savings Account"+ accountNumber+ "closed hence interest cannot be calculated");
        }
    }

    @Override
    public void closeAccount() {
        isActive = false;
        this.balance=0;
        System.out.println("Savings Account"+ accountNumber+ "closed");
    }

    @Override
    public void deposit(double amount) {
        if (isActive) {
            balance += amount;
            System.out.println("Savings Account " +accountNumber + " deposited " + amount);
        }else{
            System.out.println("Savings Account "+accountNumber + " deposited Failed" + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if(isActive && balance>0 && balance >= amount) {
            balance-=amount;
            System.out.println("Withdraw Successfully "+amount);
            System.out.println("Remaining Balance: "+balance);
        }else{
            System.out.println("Withdraw Failed "+amount);
        }
    }
}
