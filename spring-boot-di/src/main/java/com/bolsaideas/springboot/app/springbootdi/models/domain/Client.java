package com.bolsaideas.springboot.app.springbootdi.models.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Client {

    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastName;

}
