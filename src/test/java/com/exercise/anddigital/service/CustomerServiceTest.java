package com.exercise.anddigital.service;

import com.exercise.anddigital.bootstrap.CustomerBootStrap;
import com.exercise.anddigital.repositories.CustomerRepository;
import com.exercise.anddigital.repositories.PhoneRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
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

        assertNotNull(phones);
        assertThat(phones.size(), is(6));
    }

    @Test
    public void getCustomerPhoneNumbers() {
        List<String> phones = this.customerService.getCustomerPhoneNumbers(1l);

        assertNotNull(phones);
        assertThat(phones.size(), is(3));
    }

    @Test(expected = RuntimeException.class)
    public void getCustomerPhoneNumbersCustomerNotFound() {
        List<String> phones = this.customerService.getCustomerPhoneNumbers(4l);
    }

    @Test(expected = RuntimeException.class)
    public void getCustomerPhoneNumbersCustomerIllegalId() {
        List<String> phones = this.customerService.getCustomerPhoneNumbers(-1l);
    }

    @Test
    public void activatePhoneNumber() {
        this.customerService.activatePhoneNumber(1l, "987-654-3210");

        List<String> phones = this.customerService.getCustomerPhoneNumbers(1l);

        assertThat(phones.size(), is(4));
    }

    @Test(expected = RuntimeException.class)
    public void activatePhoneNumberCustomerNotFound() {
        this.customerService.activatePhoneNumber(4l, "987-654-3210");
    }

    @Test(expected = RuntimeException.class)
    public void activatePhoneNumberPhoneAlreadyExists() {
        this.customerService.activatePhoneNumber(4l, "(123) 456-7890");
    }
}