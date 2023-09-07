package com.eteration.simplebanking.model;


import java.util.Date;
import java.util.List;

// This class is a place holder you can change the complete implementation
public abstract class Transaction {
    private String transactionType;
    private Date date;

    private double amount;

    private List<Transaction> transactions;




    public Transaction(String transactionType, Date date, double amount) {
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }


    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
	
}
