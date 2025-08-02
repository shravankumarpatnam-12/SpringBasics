package com.auto.wire.loose.coupling;

import java.time.LocalDate;
import java.util.Objects;

public class FixedDeposit implements Account {
    private int fdNumber;
    private double principalAmount;
    private double interestRate;
    private int termInMonths;
    private LocalDate startDate;
    private LocalDate maturityDate;
    private boolean isPrematureWithdrawalAllowed;
    private boolean isActive;

    public FixedDeposit(int fdNumber, double principalAmount, double interestRate,
                        int termInMonths, LocalDate startDate, LocalDate maturityDate,
                        boolean isPrematureWithdrawalAllowed, boolean isActive) {
        this.fdNumber = fdNumber;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.termInMonths = termInMonths;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.isPrematureWithdrawalAllowed = isPrematureWithdrawalAllowed;
        this.isActive = isActive;
    }

    public int getFdNumber() {
        return fdNumber;
    }

    public void setFdNumber(int fdNumber) {
        this.fdNumber = fdNumber;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public boolean isPrematureWithdrawalAllowed() {
        return isPrematureWithdrawalAllowed;
    }

    public void setPrematureWithdrawalAllowed(boolean prematureWithdrawalAllowed) {
        isPrematureWithdrawalAllowed = prematureWithdrawalAllowed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FixedDeposit that)) return false;
        return fdNumber == that.fdNumber
                && Double.compare(principalAmount, that.principalAmount) == 0
                && Double.compare(interestRate, that.interestRate) == 0
                && termInMonths == that.termInMonths
                && isPrematureWithdrawalAllowed == that.isPrematureWithdrawalAllowed
                && isActive == that.isActive
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(maturityDate, that.maturityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fdNumber, principalAmount, interestRate,
                termInMonths, startDate, maturityDate, isPrematureWithdrawalAllowed, isActive);
    }

    @Override
    public void closeAccount() {
        isActive = false;
        System.out.println("Fixed deposit account " + fdNumber + " closed.");
    }

    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Deposites are not allowed for fixed deposots");
    }

    @Override
    public void withdraw(double amount) {
        if(isPrematureWithdrawalAllowed) {
            System.out.println("Withdraw Successfully "+principalAmount);
            principalAmount=0.0;
        }else{
            System.out.println("Amount is Matured. ");
        }
    }

}
