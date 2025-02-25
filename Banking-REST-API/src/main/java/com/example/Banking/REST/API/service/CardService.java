package com.example.Banking.REST.API.service;

import com.example.Banking.REST.API.dto.response.CardResponse;
import com.example.Banking.REST.API.model.Account;
import com.example.Banking.REST.API.model.Card;
import com.example.Banking.REST.API.repository.CardRepository;
import com.example.Banking.REST.API.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<CardResponse> getAllCards() {
        return cardRepository.findAll().stream().map(CardTransformer::cardToCardResponse).toList();
    }

    public Card createCard(String name, String cardType, Account account) {
        String cardNo = generateCardNO();
        Card card = CardTransformer.cardRequestToCard(cardNo, name, cardType, account);
        return cardRepository.save(card);

    }

    private String generateCardNO() {
        return "CARD-"+System.currentTimeMillis();
    }
}
