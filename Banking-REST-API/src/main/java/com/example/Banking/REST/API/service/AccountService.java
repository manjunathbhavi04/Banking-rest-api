package com.example.Banking.REST.API.service;

import com.example.Banking.REST.API.dto.response.AccountResponse;
import com.example.Banking.REST.API.model.Account;
import com.example.Banking.REST.API.repository.AccountRepository;
import com.example.Banking.REST.API.transformer.AccountTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountResponse> getAllAccounts() {
        return accountRepository.findAll().stream().map(AccountTransformer::accountToAccountResponse).toList();
    }

    public Account createAccount(String accountType) {
        String accountNo = generateAccountNo();
        Account account = AccountTransformer.accountRequestToAccount(accountNo, accountType);
        return accountRepository.save(account);
    }

    private String generateAccountNo() {
        return "ACC-"+System.currentTimeMillis();
    }


}
