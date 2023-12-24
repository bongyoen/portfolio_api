package com.co.portfolio_api.business.email;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Schema(description = "이메일 DTO")
public class EmailDto {

    @Getter
    @Setter
    @ToString
    public static class EmailCond {
        private String name;
        private String email;
        private String subject;
        private String message;

    }
    
    @Getter
    @Setter
    public static class EmailRslt {
        private String resMsg;

    }
}
