package com.example.Banking.REST.API.transformer;

import com.example.Banking.REST.API.dto.request.CardRequest;
import com.example.Banking.REST.API.dto.response.CardResponse;
import com.example.Banking.REST.API.model.Account;
import com.example.Banking.REST.API.model.Card;

import java.time.LocalDate;

public class CardTransformer {
    public static Card cardRequestToCard(String cardNo, String name, String cardType, Account account) {
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonthValue(); // Get month number (1-12)
        int currentYear = today.getYear() + 6;
        String expiryDate = currentMonth+"/"+currentYear;
        return Card.builder()
                .cardHolderName(name)
                .account(account)
                .cardNumber(cardNo)
                .cardType(cardType)
                .expiryDate(expiryDate)
                .build();
    }

    public static CardResponse cardToCardResponse(Card card) {
        return CardResponse.builder()
                .cardHolderName(card.getCardHolderName())
                .cardNumber(card.getCardNumber())
                .cardType(card.getCardType())
                .expiryDate(card.getExpiryDate())
                .build();
    }
}
