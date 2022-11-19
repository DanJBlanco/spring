package com.bolsaideas.springboot.app.springbootdi.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String operation(String input){
        return input.toUpperCase().concat("Return of service");
    }
}
