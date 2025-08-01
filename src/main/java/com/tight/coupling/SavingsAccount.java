package com.tight.coupling;

import java.io.Serializable;
import java.util.Objects;

public class SavingsAccount implements Serializable {
    private int accountNumber;
    private double balance;
    private String bankName;
    private String branchName;

    public SavingsAccount(int accountNumber, double balance, String bankName, String branchName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bankName = bankName;
        this.branchName = branchName;
        System.out.println("Account number " + accountNumber + " balance " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SavingsAccount that = (SavingsAccount) o;
        return accountNumber == that.accountNumber
                && Double.compare(balance, that.balance) == 0
                && Objects.equals(bankName, that.bankName)
                && Objects.equals(branchName, that.branchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, bankName, branchName);
    }

    @Override
    public String toString(){
        return "Saving Account {" +
                "Account number ='" + accountNumber +'\''
                + ", balance ='" + balance +'\''
                +", Bank Name ='"+bankName+'\''
                +", Branch name ='"+branchName +'\''+
                "}";
    }
}
