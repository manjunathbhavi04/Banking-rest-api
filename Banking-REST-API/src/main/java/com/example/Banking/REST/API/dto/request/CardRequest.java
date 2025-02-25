package com.example.Banking.REST.API.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    private String cardHolderName;
    private String cardNumber;
    private String cardType;
}
