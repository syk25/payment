package com.syk25.finance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.syk25.finance")
public class ApplicationConfig {
    @Autowired
    private ApplicationContext applicationContext;

    public void getResource() throws IOException {
        Resource resource = applicationContext.getResource("swen.txt");

        System.out.println(resource.contentLength());
    }

}
