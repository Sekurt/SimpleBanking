package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
// This class is a place holder you can change the complete implementation
public class AccountService {

    private Account bankAccount;
    private List<Transaction> transactions;

   /* public AccountService() {
        // Initialize the bank account object
        Account bankAccount = new Account();
        bankAccount.setOwner("John Doe");
        bankAccount.setAccountNumber("1234567890");
        bankAccount.setBalance(1000.0);

        // Initialize the transactions list
        transactions = new ArrayList<>();
    }*/
   @Autowired
   public AccountService(Account bankAccount) {
       this.bankAccount = bankAccount;
   }

    public Account findAccount(String accountNumber) {
        return bankAccount.findByAccountNumber(accountNumber);
    }


    public Account credit(double amount) {
        bankAccount.credit(amount);
        Date date = new Date();
        Transaction transaction = new DepositTransaction(amount);
        transactions.add(transaction);
        return bankAccount;
    }

    public Account debit(double amount) {
        try {
            bankAccount.debit(amount);
            Transaction transaction = new WithdrawalTransaction(new Date(),amount);
            transactions.add(transaction);
        } catch (IllegalArgumentException e) {
            // Handle insufficient funds exception and return an appropriate response
            e.printStackTrace();
        }
        return bankAccount;
    }

    public double deposit(double amount) {
        double balance = bankAccount.getBalance();
        balance += amount;
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    public double withdraw(double amount) {
        double balance = bankAccount.getBalance();
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
        return balance;
    }

    public double getBalance(String accountNumber) {

        return bankAccount.getBalance();
    }
}
