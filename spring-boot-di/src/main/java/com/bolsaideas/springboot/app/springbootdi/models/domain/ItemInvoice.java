package com.bolsaideas.springboot.app.springbootdi.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemInvoice {
    private Product product;
    private Integer quantity;
}
