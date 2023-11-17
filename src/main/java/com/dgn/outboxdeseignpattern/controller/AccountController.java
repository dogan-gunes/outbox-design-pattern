package com.dgn.outboxdeseignpattern.controller;

import com.dgn.outboxdeseignpattern.model.Account;
import com.dgn.outboxdeseignpattern.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/addAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) throws JsonProcessingException {
        return new ResponseEntity<>(accountService.addAccount(account), HttpStatus.CREATED);
    }
}
