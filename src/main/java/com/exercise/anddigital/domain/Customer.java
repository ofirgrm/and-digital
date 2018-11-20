package com.exercise.anddigital.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Getter
public class Customer {

    private Long id;
    private String name;
    private Set<String> phones;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.phones = new HashSet<>();
    }

    public void addPhones(String... phoneNumbers) {
        Stream.of(phoneNumbers).forEach(phoneNumber ->
                this.phones.add(phoneNumber));
    }
}
