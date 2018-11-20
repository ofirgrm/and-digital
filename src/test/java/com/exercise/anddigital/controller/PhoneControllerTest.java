package com.exercise.anddigital.controller;

import com.exercise.anddigital.api.PhoneRequest;
import com.exercise.anddigital.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PhoneControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private PhoneController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllCustomersPhoneNumbers() throws Exception{
        List<String> phoneNumbers = Stream.of("123","456").collect(Collectors.toList());
        when(customerService.getAllCustomersPhoneNumbers()).thenReturn(phoneNumbers);

        mockMvc.perform(get("/api/phone")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phones", hasSize(2)));
    }

    @Test
    public void getCustomerPhoneNumbers() throws Exception {
        List<String> phoneNumbers = Stream.of("123","456").collect(Collectors.toList());
        when(customerService.getCustomerPhoneNumbers(anyLong())).thenReturn(phoneNumbers);

        mockMvc.perform(get("/api/phone/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.phones", hasSize(2)));
    }

    @Test
    public void activatePhoneNumber() throws Exception {
        List<String> phoneNumbers = Stream.of("123","456").collect(Collectors.toList());
        when(customerService.getCustomerPhoneNumbers(anyLong())).thenReturn(phoneNumbers);

        PhoneRequest phoneRequest = new PhoneRequest("(987) 654-1234");

        mockMvc.perform(post("/api/phone/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(phoneRequest)))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}