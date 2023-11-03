package com.co.portfolio_api;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {
    @Value("spring.datasource.write.hikari.username")
    private String username;
    @Value("spring.datasource.write.hikari.password")
    private String password;
    @Value("spring.datasource.write.hikari.url")
    private String url;
    @Value("spring.datasource.read.hikari.url")
    private String read_url;

    private final HttpServletResponse response;
    private final HttpServletRequest request;


    @GetMapping(value = "/info")
    public ResponseEntity<String> restTest() {

        System.out.println("info컨트롤러에 도달");

        return new ResponseEntity<>("접근완료", HttpStatus.OK);
    }

    @GetMapping(value = "readTest")
    public ResponseEntity<String> readTest() {

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://portfolio-psql.cluster-ro-cht7mrcxyht1.us-east-1.rds.amazonaws.com:5432/postgres",
                        "postgres",
                        "Tmxhfl953!"
                )
        ) {
            return new ResponseEntity<>("연결! : {}" + connection.toString(), HttpStatus.OK);
        } catch (Exception ignored) {
            log.info("연결실패!");
            return new ResponseEntity<>("연결실패!", HttpStatus.OK);

        }
    }

    @GetMapping(value = "wrtieTest")
    public ResponseEntity<String> wrtieTest() {

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://portfolio-psql.cluster-cht7mrcxyht1.us-east-1.rds.amazonaws.com:5432/postgres",
                        "postgres",
                        "Tmxhfl953!"
                )
        ) {
            return new ResponseEntity<>("연결! : {}" + connection.toString(), HttpStatus.OK);
        } catch (Exception ignored) {
            log.info("연결실패!");
            return new ResponseEntity<>("연결실패!", HttpStatus.OK);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<String> restTest1() {

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://portfolio-psql.cluster-cht7mrcxyht1.us-east-1.rds.amazonaws.com:5432/postgres",
                        "postgres",
                        "Tmxhfl953!"
                )
        ) {

            log.info("연결! : {}", connection);

        } catch (Exception ignored) {
            log.info("연결실패!");

        }

        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://portfolio-psql.cluster-ro-cht7mrcxyht1.us-east-1.rds.amazonaws.com:5432/postgres",
                        "postgres",
                        "Tmxhfl953!"
                )
        ) {

            log.info("연결! : {}", connection);

        } catch (Exception ignored) {
            log.info("연결실패!");

        }

        return new ResponseEntity<>("접근완료1", HttpStatus.OK);
    }
}
