package com.loose.coupling;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class SalaryAccount implements Account{
    private int accountNumber;
    private int employeeId;
    private double interestRate;
    private String employerName;
    private double balance;
    private boolean isSalaryCreditedThisMonth;
    private LocalDate lastSalaryDate;
    private LocalDate openedDate;
    private boolean isActive;

    public SalaryAccount(int accountNumber, int employeeId, String employerName,double interestRate,
                         double balance, boolean isSalaryCreditedThisMonth, LocalDate lastSalaryDate,
                         LocalDate openedDate, boolean isActive) {
        this.accountNumber = accountNumber;
        this.employeeId = employeeId;
        this.interestRate = interestRate;
        this.employerName = employerName;
        this.balance = balance;
        this.isSalaryCreditedThisMonth = isSalaryCreditedThisMonth;
        this.lastSalaryDate = lastSalaryDate;
        this.openedDate = openedDate;
        this.isActive = isActive;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isSalaryCreditedThisMonth() {
        return isSalaryCreditedThisMonth;
    }

    public void setSalaryCreditedThisMonth(boolean salaryCreditedThisMonth) {
        isSalaryCreditedThisMonth = salaryCreditedThisMonth;
    }

    public LocalDate getLastSalaryDate() {
        return lastSalaryDate;
    }

    public void setLastSalaryDate(LocalDate lastSalaryDate) {
        this.lastSalaryDate = lastSalaryDate;
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
        if (!(o instanceof SalaryAccount that)) return false;
        return accountNumber == that.accountNumber
                && employeeId == that.employeeId
                && Double.compare(interestRate, that.interestRate) == 0
                && Double.compare(balance, that.balance) == 0
                && isSalaryCreditedThisMonth == that.isSalaryCreditedThisMonth
                && isActive == that.isActive
                && Objects.equals(employerName, that.employerName)
                && Objects.equals(lastSalaryDate, that.lastSalaryDate)
                && Objects.equals(openedDate, that.openedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, employeeId, interestRate, employerName,
                balance, isSalaryCreditedThisMonth, lastSalaryDate, openedDate, isActive);
    }

    @Override
    public String toString() {
        return "SalaryAccount{" +
                "accountNumber=" + accountNumber +
                ", employeeId=" + employeeId +
                ", interestRate=" + interestRate +
                ", employerName='" + employerName + '\'' +
                ", balance=" + balance +
                ", isSalaryCreditedThisMonth=" + isSalaryCreditedThisMonth +
                ", lastSalaryDate=" + lastSalaryDate +
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
            System.out.println("Salary Account "+accountNumber + "closed hence interest cannot be calculated");
        }
    }

    @Override
    public void closeAccount() {
        isActive = false;
        System.out.println("Salary Account "+accountNumber + "closed ");
    }

    @Override
    public void deposit(double amount) {
        if (isActive && isSalaryCreditedThisMonth) {
            isSalaryCreditedThisMonth = true;
            balance += amount;
            System.out.println("Salary Account deposited " + amount);
        }else{
            System.out.println("Salary Account  deposited Failed" + amount);
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
