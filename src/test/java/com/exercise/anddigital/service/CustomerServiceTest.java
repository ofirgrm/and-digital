package com.exercise.anddigital.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        this.customerService = new CustomerServiceImpl();
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