package com.bolsaideas.springboot.app.springbootdi.service;

import org.springframework.stereotype.Service;

@Service("oracleService")
public class OracleService implements IService{
    @Override
    public String operation(String input) {
        return "Return oracle response";
    }
}
