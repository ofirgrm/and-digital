package com.exercise.anddigital.controller;

import com.exercise.anddigital.api.PhoneResult;
import com.exercise.anddigital.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
@Api(value = "Customer Phone Numbers API", produces = MediaType.APPLICATION_JSON_VALUE)
public class PhoneController {

    private CustomerService customerService;

    public PhoneController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get all phone numbers allocated to all customers")
    public PhoneResult getAllCustomersPhoneNumbers() {
        List<String> phones = this.customerService.getAllCustomersPhoneNumbers();
        return new PhoneResult(phones);
    }

    @GetMapping("{customerId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Get all phone numbers allocated to the provided customer by Customer ID")
    public PhoneResult getCustomerPhoneNumbers(@PathVariable Long customerId) {
        List<String> phones = this.customerService.getCustomerPhoneNumbers(customerId);
        return new PhoneResult(phones);
    }

    @PostMapping("{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Activate a phone number for the provided customer by Customer ID")
    public void activatePhoneNumber(@PathVariable Long customerId,
                                    @RequestParam String phone) {
        this.customerService.activatePhoneNumber(customerId, phone);
    }

}
