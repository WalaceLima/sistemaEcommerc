package com.possistemaecommerc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.possistemaecommerc")
public class ProjetoPosSistemaEcommercApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoPosSistemaEcommercApplication.class, args);
    }

    private static Class<ProjetoPosSistemaEcommercApplication>
            applicationClass = ProjetoPosSistemaEcommercApplication.class;

    @Override
    protected SpringApplicationBuilder configure
            (SpringApplicationBuilder builder) {
        return builder.sources(applicationClass);
    }
}
