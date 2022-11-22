package com.bolsaideas.springboot.app.springbootdi;

import com.bolsaideas.springboot.app.springbootdi.service.IService;
import com.bolsaideas.springboot.app.springbootdi.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean("mySimpleService")
    public IService signUpMyService() {
        return new MyService();
    }
}
