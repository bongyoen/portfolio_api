package com.co.portfolio_api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    
    @GetMapping(value = "/info")
    public ResponseEntity<String> restTest() {

        System.out.println("info컨트롤러에 도달");
        return new ResponseEntity<>("접근완료", HttpStatus.OK);
    }
}
