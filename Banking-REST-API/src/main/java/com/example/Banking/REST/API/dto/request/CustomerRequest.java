package com.example.Banking.REST.API.dto.request;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {
    private String name;
    private String email;
    private String phone_no;
    private String address;
    private String cardType;
    private String accountType;

    private LocalDate dob;
}
