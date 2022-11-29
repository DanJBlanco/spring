package com.bolsaideas.springboot.app.springbootdi.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private Double price;

}
