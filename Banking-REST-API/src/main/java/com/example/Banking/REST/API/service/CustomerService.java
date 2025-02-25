package com.example.Banking.REST.API.service;

import com.example.Banking.REST.API.dto.request.CustomerRequest;
import com.example.Banking.REST.API.dto.response.CustomerResponse;
import com.example.Banking.REST.API.model.Account;
import com.example.Banking.REST.API.model.Card;
import com.example.Banking.REST.API.model.Customer;
import com.example.Banking.REST.API.repository.CustomerRepository;
import com.example.Banking.REST.API.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CardService cardService;

    public List<CustomerResponse> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(CustomerTransformer::customerToCustomerResponse).toList();
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);

        //when a customer is created then account and card are created automatically
        Account account = accountService.createAccount(savedCustomer.getAccountType());
        Card savedCard = cardService.createCard(savedCustomer.getName(), savedCustomer.getCardType(), account);

        List<Account> acc = customer.getAccountList();
        if (acc == null) {
            acc = new ArrayList<>();
        }
        acc.add(account);
        savedCustomer.setAccountList(acc);
        customerRepository.save(savedCustomer);

        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }
}
