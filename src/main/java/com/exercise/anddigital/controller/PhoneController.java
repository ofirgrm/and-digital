package com.exercise.anddigital.controller;

import com.exercise.anddigital.api.PhoneResult;
import com.exercise.anddigital.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {

    private CustomerService customerService;

    public PhoneController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PhoneResult getAllCustomersPhoneNumbers() {
        List<String> phones = this.customerService.getAllCustomersPhoneNumbers();
        return new PhoneResult(phones);
    }

    @GetMapping("{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public PhoneResult getCustomerPhoneNumbers(@PathVariable Long customerId) {
        List<String> phones = this.customerService.getCustomerPhoneNumbers(customerId);
        return new PhoneResult(phones);
    }

    public void activatePhoneNumber(@PathVariable Long customerId,
                                    @PathVariable String phoneNumber) {

    }

}
