package com.example.Banking.REST.API.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String name;
    private String email;
    private String phone_no;
    private String address;
    private String cardType;
    private String accountType;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Instant lastUpdateAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Account> accountList = new ArrayList<>();
}
