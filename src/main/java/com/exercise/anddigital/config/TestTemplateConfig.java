package com.exercise.anddigital.config;

import com.exercise.anddigital.repositories.CustomerRepository;
import com.exercise.anddigital.repositories.PhoneRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestTemplateConfig {

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public PhoneRepository phoneRepository() {
        return new PhoneRepository();
    }

}
