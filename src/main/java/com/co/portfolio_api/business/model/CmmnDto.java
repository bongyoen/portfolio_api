package com.co.portfolio_api.business.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CmmnDto {

    @Getter
    @Setter
    public static class CmmnClDto {
        private String clCode;
        private String clCodeAlt;
        private String upperClCode;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CmmnClDtlDto {
        private String clDtlCode;
        private String clCode;
        private String clCodeDtlAlt;

    }
}
