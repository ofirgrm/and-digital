package com.exercise.anddigital.bootstrap;

import com.exercise.anddigital.domain.Customer;
import com.exercise.anddigital.repositories.CustomerRepository;
import com.exercise.anddigital.repositories.PhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@Component
public class CustomerBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerRepository customerRepository;
    private PhoneRepository phoneRepository;
    private String[] phones = new String[]{
            "(123) 456-7890", "234-567-8901", "234-567-8901",
            "(231) 564-8907", "342-675-9018",
            "(312) 645-9078"
    };

    public CustomerBootStrap(CustomerRepository customerRepository, PhoneRepository phoneRepository) {
        this.customerRepository = customerRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Bootstrap sample customers");
        createPhones();
        createCustomers();
    }

    private void createPhones() {
        Stream.of(phones).forEach(phoneNumber ->
                this.phoneRepository.addPhoneNumber(phoneNumber));
    }

    private void createCustomers() {
        Customer customer1 = new Customer(1l, "Scott");
        customer1.addPhones(Arrays.copyOfRange(this.phones, 0, 2));
        Customer customer2 = new Customer(2l, "Lee");
        customer2.addPhones(Arrays.copyOfRange(this.phones, 3, 4));
        Customer customer3 = new Customer(3l, "Zoe");
        customer3.addPhones(this.phones[4]);

        this.customerRepository.saveCustomers(customer1, customer2, customer3);
    }
}
