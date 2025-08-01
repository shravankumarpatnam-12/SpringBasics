package com.tight.coupling;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    public SavingsAccount savingsAccount;

    public Customer(String firstName, String lastName, String email, long phoneNumber, SavingsAccount savingsAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.savingsAccount = savingsAccount;
        System.out.println("Customer " + firstName + " " + lastName + " " + email + " " + phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phoneNumber == customer.phoneNumber
                && Objects.equals(firstName, customer.firstName)
                && Objects.equals(lastName, customer.lastName)
                && Objects.equals(email, customer.email) &&
                Objects.equals(savingsAccount, customer.savingsAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, phoneNumber, savingsAccount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", savingsAccount=" + savingsAccount +
                '}';
    }
}
