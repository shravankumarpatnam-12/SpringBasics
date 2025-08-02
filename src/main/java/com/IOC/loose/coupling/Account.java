package com.IOC.loose.coupling;
import java.io.Serializable;

public interface Account extends Serializable {
    void deposit(double amount);
    void withdraw(double amount);
    void closeAccount();

}
