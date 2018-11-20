package com.exercise.anddigital.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<String> getAllCustomersPhoneNumbers() {
        return null;
    }

    @Override
    public List<String> getCustomerPhoneNumbers(Long customerId) {
        return null;
    }

    @Override
    public void activatePhoneNumber(Long customerId, String phoneNumber) {

    }
}
