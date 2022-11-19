package com.bolsaideas.springboot.app.springbootdi.service;

import org.springframework.stereotype.Service;

@Service("mySimpleService")
public class MyService implements IService{
    @Override
    public String operation(String input) {
        return "Execute from a interface";
    }

//    public String operation(String input){
//        return input.toUpperCase().concat("Return of service");
//    }


}
