package com.exercise.anddigital.repositories;

import java.util.HashSet;
import java.util.Set;

/**
 * Mock a "real" repository for holding the phones
 */
public class PhoneRepository {

    private Set<String> phones = new HashSet<>();

    public boolean addPhoneNumber(String phoneNumber) {
        if (checkAvailability(phoneNumber)) {
            this.phones.add(phoneNumber);
            return true;
        }

        return false;
    }

    private boolean checkAvailability(String phoneNumber) {
        return !this.phones.contains(phoneNumber);
    }

}
