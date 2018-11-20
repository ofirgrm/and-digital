package com.exercise.anddigital.api;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhoneRequest {

    private String phone;

    public PhoneRequest(String phone) {
        this.phone = phone;
    }
}
