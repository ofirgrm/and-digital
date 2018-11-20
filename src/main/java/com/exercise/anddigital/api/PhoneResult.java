package com.exercise.anddigital.api;

import lombok.Getter;

import java.util.List;

@Getter
public class PhoneResult {

    private List<String> phones;

    public PhoneResult(List<String> phones) {
        this.phones = phones;
    }
}
