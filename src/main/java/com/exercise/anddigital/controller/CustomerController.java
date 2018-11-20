package com.exercise.anddigital.controller;

import com.exercise.anddigital.api.PhoneResult;
import com.exercise.anddigital.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public PhoneResult getAllCustomersPhoneNumbers() {
        return null;
    }

    public List<String> getCustomerPhoneNumbers(@PathVariable Long customerId) {
        return null;
    }

    public void activatePhoneNumber(@PathVariable Long customerId,
                                    @PathVariable String phoneNumber) {

    }

}
