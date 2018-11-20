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
        return this.customerRepository.findCustomerById(customerId).getPhones()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public void activatePhoneNumber(Long customerId, String phoneNumber) {
        if (this.phoneRepository.addPhoneNumber(phoneNumber)) {
            this.customerRepository.findCustomerById(customerId)
                    .getPhones().add(phoneNumber);
        } else {
            throw new RuntimeException(
                    String.format("Phone number %d is already reserved", phoneNumber));
        }
    }

}
