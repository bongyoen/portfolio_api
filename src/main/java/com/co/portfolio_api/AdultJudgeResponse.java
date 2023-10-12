package com.co.portfolio_api;

import lombok.Getter;

@Getter
public class AdultJudgeResponse {
    private final String result;

    public AdultJudgeResponse(String result) {
        this.result = result;
    }

}