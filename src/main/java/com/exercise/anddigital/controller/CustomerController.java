package com.exercise.anddigital.controller;

import com.exercise.anddigital.api.PhoneResult;
import com.exercise.anddigital.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{allphones}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneResult getAllCustomersPhoneNumbers() {
        List<String> phones = this.customerService.getAllCustomersPhoneNumbers();
        return new PhoneResult(phones);
    }

    public List<String> getCustomerPhoneNumbers(@PathVariable Long customerId) {
        return null;
    }

    public void activatePhoneNumber(@PathVariable Long customerId,
                                    @PathVariable String phoneNumber) {

    }

}
