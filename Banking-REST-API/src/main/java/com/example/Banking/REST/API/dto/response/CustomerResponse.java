package com.example.Banking.REST.API.dto.response;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {
    private String name;
    private String email;
    private String phone_no;
    private String address;
    private String cardType;
    private String accountType;

    private LocalDate dob;
}
