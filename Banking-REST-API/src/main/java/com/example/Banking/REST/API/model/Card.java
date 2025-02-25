package com.example.Banking.REST.API.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardHolderName;
    private String cardNumber;
    private String cardType; // DEBIT or CREDIT
    private String expiryDate;

    @ManyToOne
    @JoinColumn(name = "account_id") // Foreign key linking to Account
    private Account account;

}
