package com.exercise.anddigital.service;

import com.exercise.anddigital.repositories.CustomerRepository;
import com.exercise.anddigital.repositories.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private PhoneRepository phoneRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, PhoneRepository phoneRepository) {
        this.customerRepository = customerRepository;
        this.phoneRepository = phoneRepository;
    }


    @Override
    public List<String> getAllCustomersPhoneNumbers() {
        return this.customerRepository.findAllCustomers()
                .stream()
                .flatMap(customers -> customers.getPhones().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCustomerPhoneNumbers(Long customerId) {
        return null;
    }

    @Override
    public void activatePhoneNumber(Long customerId, String phoneNumber) {

    }
}
