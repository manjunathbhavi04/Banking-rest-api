package com.example.Banking.REST.API.transformer;

import com.example.Banking.REST.API.dto.response.AccountResponse;
import com.example.Banking.REST.API.model.Account;
import com.example.Banking.REST.API.repository.AccountRepository;

public class AccountTransformer {
    public static Account accountRequestToAccount(String accountNo, String accountType) {
        return Account.builder()
                .accountNo(accountNo)
                .accountType(accountType)
                .balance(0.0)
                .build();
    }

    public static AccountResponse accountToAccountResponse(Account account) {
        return AccountResponse.builder()
                .accountNo(account.getAccountNo())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .build();
    }
}
