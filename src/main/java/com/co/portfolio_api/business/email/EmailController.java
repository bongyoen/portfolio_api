package com.co.portfolio_api.business.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Slf4j
public class EmailController {
    private final EmailService service;


    @PostMapping(value = "/postSendEmail")
    public ResponseEntity<EmailDto.EmailRslt> postSendEmail(@RequestBody EmailDto.EmailCond cond) {
        return service.sendEmail(cond);
    }
}
