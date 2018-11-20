package com.exercise.anddigital.service;

import com.exercise.anddigital.bootstrap.CustomerBootStrap;
import com.exercise.anddigital.repositories.CustomerRepository;
import com.exercise.anddigital.repositories.PhoneRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private PhoneRepository phoneRepository;
    private CustomerBootStrap customerBootStrap;

    @Before
    public void setUp() throws Exception {
        this.customerRepository = new CustomerRepository();
        this.phoneRepository = new PhoneRepository();
        this.customerBootStrap = new CustomerBootStrap(this.customerRepository,
                this.phoneRepository);
        this.customerBootStrap.execute();
        this.customerService = new CustomerServiceImpl(this.customerRepository,
                this.phoneRepository);
    }

    @Test
    public void getAllCustomersPhoneNumbers() {
        List<String> phones = this.customerService.getAllCustomersPhoneNumbers();

        assertThat(phones.size(), is(6));
    }

    @Test
    public void getCustomerPhoneNumbers() {

    }

    @Test
    public void activatePhoneNumber() {
    }
}