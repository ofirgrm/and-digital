package com.exercise.anddigital.repositories;

import com.exercise.anddigital.domain.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Mock a "real" repository for holding the customers
 */
public class CustomerRepository {

    private Map<Long, Customer> customers = new HashMap<>();

    public void saveCustomers(Customer... customers) {
        Objects.requireNonNull(customers);
        Stream.of(customers).forEach(customer ->
                this.customers.put(customer.getId(), customer));
    }

}
