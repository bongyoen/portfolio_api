package com.co.portfolio_api.business.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final EmailRepository repository;

    public ResponseEntity<EmailDto.EmailRslt> sendEmail(EmailDto.EmailCond cond) {
        EmailDto.EmailRslt rslt = new EmailDto.EmailRslt();
        try {
            repository.insertEmail(cond);
            rslt.setResMsg("success");
            return new ResponseEntity<>(rslt, HttpStatus.OK);
        } catch (Exception e) {
            rslt.setResMsg("fail");
            return new ResponseEntity<>(rslt, HttpStatus.BAD_REQUEST);
        }
    }
}
