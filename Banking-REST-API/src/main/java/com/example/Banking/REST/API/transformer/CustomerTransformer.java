package com.example.Banking.REST.API.transformer;

import com.example.Banking.REST.API.dto.request.CustomerRequest;
import com.example.Banking.REST.API.dto.response.CustomerResponse;
import com.example.Banking.REST.API.model.Customer;

public class CustomerTransformer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .dob(customerRequest.getDob())
                .phone_no(customerRequest.getPhone_no())
                .address(customerRequest.getAddress())
                .cardType(customerRequest.getCardType())
                .accountType(customerRequest.getAccountType())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .dob(customer.getDob())
                .phone_no(customer.getPhone_no())
                .accountType(customer.getAccountType())
                .cardType(customer.getCardType())
                .build();
    }
}
