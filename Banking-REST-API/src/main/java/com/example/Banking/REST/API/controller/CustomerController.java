package com.example.Banking.REST.API.controller;

import com.example.Banking.REST.API.dto.request.CustomerRequest;
import com.example.Banking.REST.API.dto.response.CustomerResponse;
import com.example.Banking.REST.API.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> allCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse savedCustomer = customerService.addCustomer(customerRequest);
        return savedCustomer;
    }
}
