package com.bolsaideas.springboot.app.springbootdi.models.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;
import java.util.List;

@Component
@Data
//@RequestScope
public class Invoice {



    @Value("${invoice.description}")
    private String description;

    @Autowired
    private Client client;

    @Autowired
    private List<ItemInvoice> items;

    @PostConstruct
    public void init(){
        client.setName(client.getName().concat(" ").concat("José"));
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Invoice destry: ".concat(description));
    }


}
