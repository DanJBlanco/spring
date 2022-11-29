package com.bolsaideas.springboot.app.springbootdi.models.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Invoice {

    @Value("${invoice.description}")
    private String description;

    @Autowired
    private Client client;

    private List<ItemInvoice> itemInvoices;
}
