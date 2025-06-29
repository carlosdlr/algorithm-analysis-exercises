package com.carlosdlr.algorithm.exercises.ing;

import java.util.*;

enum StateInfo {
    LOGGED_IN, LOGGED_OUT, SUSPENDED, ERROR
}

interface BankAccountState {
    public StateInfo login(String password);
    public StateInfo logout();
    public StateInfo unlock(int resetCode);
    public StateInfo withdrawMoney(int amount);
}
public class BankAccount {
    private BankAccountState loggedIn;
    private BankAccountState loggedOut;
    private BankAccountState suspended;
    private BankAccountState bankAccountState;
    private int cashBalance;
    private String password;
    private int passwordRetries;
    private int resetCode;

    public static void main(String[] args) throws Exception {
        BankAccount bankAccount = new BankAccount(1000, "123", 456);

        bankAccount.getLoggedInState().logout();
    }

    public BankAccount(int cashBalance, String password, int resetCode) {
        this.cashBalance = cashBalance;
        this.password = password;
        this.resetCode = resetCode;
        this.loggedIn = new LoggedIn(this);
        this.loggedOut = new LoggedOut(this);
        this.suspended = new Suspended(this);

    }

    public void setState(BankAccountState state) {
        this.bankAccountState = state;
    }

    public BankAccountState getState() {
        return this.bankAccountState;
    }

    public BankAccountState getLoggedInState() {
        return this.loggedIn;
    }

    public BankAccountState getLoggedOutState() {
        return this.loggedOut;
    }

    public BankAccountState getSuspendedState() {
        return this.suspended;
    }

    public StateInfo login(String password) {
        return this.bankAccountState.login(password);
    }

    public StateInfo logout() {
        return this.bankAccountState.logout();
    }

    public StateInfo unlock(int resetCode) {
        return this.bankAccountState.unlock(resetCode);
    }

    public StateInfo withdrawMoney(int amount) {
        return this.bankAccountState.withdrawMoney(amount);
    }

    public void setCashBalance(int amount) {
        this.cashBalance = amount;
    }

    public int getCashBalance() {
        return this.cashBalance;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPasswordRetries(int passwordRetries) {
        this.passwordRetries = passwordRetries;
    }

    public int getPasswordRetries() {
        return this.passwordRetries;
    }

    public int getResetCode() {
        return this.resetCode;
    }
}

// YOUR SOLUTION HERE
class LoggedIn implements BankAccountState{

    private BankAccount bankAccount;
    public LoggedIn(BankAccount bankAccount) {
     this.bankAccount = bankAccount;
    }

    @Override
    public StateInfo login(String password) {
        return StateInfo.SUSPENDED;
    }

    @Override
    public StateInfo logout() {
        bankAccount.setState(bankAccount.getLoggedOutState());
        return null;
    }

    @Override
    public StateInfo unlock(int resetCode) {
        return null;
    }

    @Override
    public StateInfo withdrawMoney(int amount) {
        if(amount <= bankAccount.getCashBalance()) {
            bankAccount.setCashBalance(bankAccount.getCashBalance() - amount);
        }
        return null;
    }
}

// YOUR SOLUTION HERE
class LoggedOut  implements BankAccountState{
    private BankAccount bankAccount;

    public LoggedOut(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public StateInfo login(String password) {
        if(password != bankAccount.getPassword()) {
            bankAccount.setPasswordRetries(bankAccount.getPasswordRetries()+1);
        }

        if (bankAccount.getPasswordRetries()> 2) {
            bankAccount.setState(bankAccount.getSuspendedState());
        }

        bankAccount.setState(bankAccount.getLoggedInState());

        return StateInfo.LOGGED_IN;


    }

    @Override
    public StateInfo logout() {
        return StateInfo.LOGGED_OUT;
    }

    @Override
    public StateInfo unlock(int resetCode) {
        return null;
    }

    @Override
    public StateInfo withdrawMoney(int amount) {
        return null;
    }
}

// YOUR SOLUTION HERE
class Suspended implements BankAccountState {
    private BankAccount bankAccount;

    public Suspended (BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public StateInfo login(String password) {
        return bankAccount.getSuspendedState().login(password);
    }

    @Override
    public StateInfo logout() {
        return null;
    }

    @Override
    public StateInfo unlock(int resetCode) {
        if(resetCode == bankAccount.getResetCode()) {
            bankAccount.setPasswordRetries(0);
            bankAccount.setState(bankAccount.getLoggedOutState());
        }
        return  StateInfo.LOGGED_OUT;
    }

    @Override
    public StateInfo withdrawMoney(int amount) {
        return null;
    }
}