package com.bolsaideas.springboot.app.springbootdi.models.domain;

import lombok.Data;

@Data
public class ItemInvoice {
    private Product product;
    private Integer quantity;
}
