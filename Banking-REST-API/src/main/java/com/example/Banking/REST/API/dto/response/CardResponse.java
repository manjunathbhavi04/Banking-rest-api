package com.example.Banking.REST.API.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String cardHolderName;
    private String cardNumber;
    private String cardType; // DEBIT or CREDIT
    private String expiryDate;
}
