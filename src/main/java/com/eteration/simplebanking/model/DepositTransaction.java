package com.eteration.simplebanking.model;


import java.util.Date;

// This class is a place holder you can change the complete implementation
public class DepositTransaction extends Transaction {

    public DepositTransaction( double amount) {

        super("deposit",new Date(),amount);
        setDate(new Date());
        setAmount(amount);
        setTransactionType("Deposit");
    }



}

