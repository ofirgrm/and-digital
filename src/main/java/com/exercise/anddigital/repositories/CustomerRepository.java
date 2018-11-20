package com.exercise.anddigital.repositories;

import com.exercise.anddigital.domain.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
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

    public Customer findCustomerById(Long id) {
        Objects.requireNonNull(id);
        if (id > 0) {
            if (this.customers.containsKey(id)) {
                return this.customers.get(id);
            } else {
                throw new RuntimeException(String.format("Customer %d not found", id));
            }
        }
        throw new RuntimeException("Illegal Key");
    }

    public Set<Customer> findAllCustomers() {
        return customers.values().stream().collect(Collectors.toSet());
    }

}
