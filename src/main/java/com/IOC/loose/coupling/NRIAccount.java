package com.IOC.loose.coupling;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class NRIAccount implements Account {

    private int accountNumber;
    private String nriType; // NRE, NRO, or FCNR
    private String countryOfResidence;
    private double balance;
    private double interestRate;
    private String currency;
    private String openedDate;
    private boolean isActive;

    public NRIAccount(int accountNumber, String nriType, String countryOfResidence,
                      double balance, double interestRate, String currency, String openedDate, boolean isActive) {
        this.accountNumber = accountNumber;
        this.nriType = nriType;
        this.countryOfResidence = countryOfResidence;
        this.balance = balance;
        this.interestRate = interestRate;
        this.currency = currency;
        this.openedDate = openedDate;
        this.isActive = isActive;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getNriType() {
        return nriType;
    }

    public void setNriType(String nriType) {
        this.nriType = nriType;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(String openedDate) {
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
        if (!(o instanceof NRIAccount that)) return false;
        return accountNumber == that.accountNumber
                && Double.compare(balance, that.balance) == 0
                && Double.compare(interestRate, that.interestRate) == 0
                && isActive == that.isActive
                && Objects.equals(nriType, that.nriType)
                && Objects.equals(countryOfResidence, that.countryOfResidence)
                && Objects.equals(currency, that.currency)
                && Objects.equals(openedDate, that.openedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, nriType, countryOfResidence,
                balance, interestRate, currency, openedDate, isActive);
    }

    @Override
    public String toString() {
        return "NRIAccount{" +
                "accountNumber=" + accountNumber +
                ", nriType='" + nriType + '\'' +
                ", countryOfResidence='" + countryOfResidence + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", currency='" + currency + '\'' +
                ", openedDate=" + openedDate +
                ", isActive=" + isActive +
                '}';
    }


    @Override
    public void closeAccount() {
        isActive = false;
        System.out.println("NRI Account"+ accountNumber+"closed ");
    }

    @Override
    public void deposit(double amount) {
        if (isActive) {
            balance += amount;
            System.out.println("NRI Account deposited " + amount);
        }else{
            System.out.println("NRI Account deposited Failed" + amount);
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
