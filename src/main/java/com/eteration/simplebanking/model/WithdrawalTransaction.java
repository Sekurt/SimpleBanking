package com.eteration.simplebanking.model;


import java.util.Date;

// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends  Transaction{
    public WithdrawalTransaction(Date date, double amount) {
        super("withdrawal", date, amount);
        setDate(date);
        setAmount(amount);
    }
    public String getTransactionType() {
        return "Withdrawal";
    }
}


