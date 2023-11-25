package com.co.portfolio_api.business.menu;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService service;
    @GetMapping(value = "/webHeaders")
    public ResponseEntity<MenuDto.WebHeaderRslt> getWebHeaders() {
        try {
            return new ResponseEntity<>(service.getWebHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
