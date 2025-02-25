package com.example.Banking.REST.API.controller;

import com.example.Banking.REST.API.dto.response.CardResponse;
import com.example.Banking.REST.API.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    public ResponseEntity<List<CardResponse>> getAllCards() {
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }

}
