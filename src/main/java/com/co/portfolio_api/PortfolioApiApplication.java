package com.co.portfolio_api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class PortfolioApiApplication implements ApplicationRunner {
    @Autowired
    private ServerProperties serverProperties;

    public static void main(String[] args) {

        System.out.println("스프링부트 시작!");
        SpringApplication.run(PortfolioApiApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        int configuredPort = serverProperties.getPort();
        System.out.println("설정된 포트: " + configuredPort);
    }
}
