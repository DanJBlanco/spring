package com.bolsaideas.springboot.app.springbootdi;

import com.bolsaideas.springboot.app.springbootdi.models.domain.ItemInvoice;
import com.bolsaideas.springboot.app.springbootdi.models.domain.Product;
import com.bolsaideas.springboot.app.springbootdi.service.IService;
import com.bolsaideas.springboot.app.springbootdi.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("mySimpleService")
    public IService signUpMyService() {
        return new MyService();
    }

    @Bean("itemsInvoice")
    public List<ItemInvoice> registerItems(){
        Product product = new Product("Product1", 16.6);
        Product product2 = new Product("Product2", 216.6);
        ItemInvoice itemInvoice = new ItemInvoice(product, 4);
        ItemInvoice itemInvoice2 = new ItemInvoice(product2, 43);

        return Arrays.asList(itemInvoice, itemInvoice2);
    }
}
