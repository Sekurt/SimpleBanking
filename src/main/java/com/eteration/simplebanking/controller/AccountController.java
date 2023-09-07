package com.eteration.simplebanking.controller;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RestController(value = "/account/v1")
// This class is a place holder you can change the complete implementation
public class AccountController {

    @Autowired
    private AccountService accountService ;
    /*public void createAccount(String owner, String accountNumber) {
        Account acct = new Account(owner, accountNumber);
        accountService.createAccount(acct);
    }*/
    @PostMapping("/create_account")
    public String createAccount(@RequestParam("account_name")String accountName,
                                @RequestParam("account_type")String accountType,
                                RedirectAttributes redirectAttributes,
                                HttpSession session){


        if(accountName.isEmpty() || accountType.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Account Name and Type Cannot be Empty!");
            return "redirect:/app/dashboard";
        }
        return "redirect:/account/v1";
    }
        @PostMapping(value = "/credit")
        public String credit(@RequestParam("account_number")String accountNumber,
                             @RequestParam("amount")double amount,
                             RedirectAttributes redirectAttributes,
                             HttpSession session){
        if(accountNumber.isEmpty() || amount <= 0){
            redirectAttributes.addFlashAttribute("error", "Account Number and Amount Cannot be Empty!");
            return "redirect://account/v1";
        }
        else {
            accountService.credit(amount);
        }
        return "redirect:/account/v1";
        }

        @PostMapping(value = "/debit")
        public String debit(@RequestParam("account_number")String accountNumber,
                             @RequestParam("amount")double amount,
                             RedirectAttributes redirectAttributes,
                             HttpSession session) {
            if (accountNumber.isEmpty() || amount <= 0) {
                redirectAttributes.addFlashAttribute("error", "Account Number and Amount Cannot be Empty!");
                return "redirect://account/v1";
            } else {
                accountService.debit(amount);
                return "redirect:/account/v1";

            }
        }

        @PostMapping(value = "/credit/{accountNumber}")
            public void Deposit(@PathVariable String accountNumber , @RequestBody double amount   ) {

            accountService.deposit(amount);

        }
        @PostMapping(value = "/debit/{accountNumber}")
            public void Withdraw(@PathVariable String accountNumber, @RequestBody double amount   ) {
            accountService.withdraw(amount);
            }

        @GetMapping(value = "/{accountNumber}")
            public double getBalance(@PathVariable String accountNumber) {
                return accountService.getBalance(accountNumber);
            }

    //ToDo: Implement getAccount method
    public ResponseEntity<Account> getAccount(String accountNumber) {


    }
}