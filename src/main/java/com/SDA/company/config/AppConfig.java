package com.SDA.company.config;

import com.SDA.company.component.CustomFaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomFaker customFaker(){
        return new CustomFaker();
    }

}
