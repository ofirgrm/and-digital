package com.exercise.anddigital.service;

import java.util.List;

public interface CustomerService {

    List<String> getAllCustomersPhoneNumbers();

    List<String> getCustomerPhoneNumbers(Long customerId);

    void activatePhoneNumber(Long customerId, String phoneNumber);

}
