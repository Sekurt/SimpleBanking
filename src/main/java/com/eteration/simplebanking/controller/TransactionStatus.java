package com.eteration.simplebanking.controller;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// This class is a place holder you can change the complete implementation
@RestController(value = "/account/v1")
public class TransactionStatus {
    @Autowired
    private Account bankAccount;
    @Autowired
    private Transaction transaction;

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public List<Transaction> getTransactions() {
        return bankAccount.getTransactions();
    }


    @RequestMapping(value = "/transactions/{transactionId}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable("transactionId") String transactionId) {
        return transaction;
    }

/*
    public String getStatus() {
        return deposit || withdraw;
    }*/
}
