package com.co.portfolio_api;


import com.co.portfolio_api.db.RoutingDataSourceImpl;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {
    @Value("spring.datasource.write.hikari.username")
    private String username;
    @Value("spring.datasource.write.hikari.password")
    private String password;
    @Value("spring.datasource.write.hikari.url")
    private String url;
    @Value("spring.datasource.read.hikari.url")
    private String read_url;

    @GetMapping(value = "/info")
    public ResponseEntity<String> restTest() {

        System.out.println("info컨트롤러에 도달");
        return new ResponseEntity<>("접근완료", HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> restTest1() {

        DataSource writeDataSource = DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(url)
                .username(username)
                .password(password)
                .type(HikariDataSource.class)
                .build();
        DataSource readDataSource = DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(read_url)
                .username(username)
                .password(password)
                .type(HikariDataSource.class)
                .build();

        RoutingDataSourceImpl routingDataSourceImpl = new RoutingDataSourceImpl();
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("write", writeDataSource);
        targetDataSource.put("read", readDataSource);
        routingDataSourceImpl.setTargetDataSources(targetDataSource);
        routingDataSourceImpl.setDefaultTargetDataSource(writeDataSource);

        new LazyConnectionDataSourceProxy(routingDataSourceImpl);

        return new ResponseEntity<>("접근완료1", HttpStatus.OK);
    }
}
