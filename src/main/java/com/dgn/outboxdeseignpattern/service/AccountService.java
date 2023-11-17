package com.dgn.outboxdeseignpattern.service;

import com.dgn.outboxdeseignpattern.model.Account;
import com.dgn.outboxdeseignpattern.repository.AccountRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final OutBoxService outBoxService;

    public AccountService(AccountRepository accountRepository, OutBoxService outBoxService) {
        this.accountRepository = accountRepository;
        this.outBoxService = outBoxService;
    }

    @Transactional
    public Account addAccount(Account account) throws JsonProcessingException {
        final Account saveAccount = accountRepository.save(account);
        outBoxService.addOutBox(saveAccount);
        return saveAccount;
    }
}
