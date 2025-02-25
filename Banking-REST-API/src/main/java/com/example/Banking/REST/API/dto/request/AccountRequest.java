package com.example.Banking.REST.API.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequest {
    private String accountNo;
    private String accountType;
    private double balance;
}
