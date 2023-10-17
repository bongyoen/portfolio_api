package com.co.portfolio_api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class PortfolioApiApplication implements ApplicationRunner{

    public static void main(String[] args) {

        System.out.println("스프링부트 시작!");
        SpringApplication.run(PortfolioApiApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


    }
}
