package com.example.Banking.REST.API.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponse {
    private String accountNo;
    private String accountType;
    private double balance;
}
