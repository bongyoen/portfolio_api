package com.co.portfolio_api.business.resource;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
@Slf4j
public class ResourceController {

    private final ResourceService service;


    @PostMapping("/image")
    public ResponseEntity<ResourceDto.ResourceRslt> postImageUrl(@RequestBody ResourceDto.ResourceCond cond) {
        try {
            return new ResponseEntity<>(service.postImageUrl(cond), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/images")
    public ResponseEntity<List<ResourceDto.ResourceRslt>> postImagesUrl(@RequestBody List<ResourceDto.ResourceCond> cond) {
        try {
            return new ResponseEntity<>(service.postImagesUrl(cond), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
