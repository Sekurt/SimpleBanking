package com.eteration.simplebanking.model;



// This class is a place holder you can change the complete implementation

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;


public class Account {
    private String owner;
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.owner = owner;
        this.accountNumber = accountNumber;}

    public Account(String owner, String accountNumber) {
        super();
        this.owner = owner;
        this.accountNumber = accountNumber;

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
    public void post(Transaction transaction) {
        if (transaction instanceof DepositTransaction) {
            DepositTransaction deposit = (DepositTransaction) transaction;
            credit(deposit.getAmount());
        } else if (transaction instanceof WithdrawalTransaction) {
            WithdrawalTransaction withdrawal = (WithdrawalTransaction) transaction;
            debit(withdrawal.getAmount());
        } else {
            // Handle other transaction types (e.g., PhoneBillPaymentTransaction)
        }
        transactions.add(transaction);
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
        return balance;
    }
    //TODO: implement method to find account information by accountNumber
    public Account findByAccountNumber(String accountNumber) {
        return null;
    }
}

