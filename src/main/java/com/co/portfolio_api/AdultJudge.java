package com.co.portfolio_api;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AdultJudge implements Function<UserRequest, AdultJudgeResponse> {
    @Override
    public AdultJudgeResponse apply(UserRequest request) {

        System.out.println("here?");
        String name = request.getName();

        if (request.getAge() > 20) {
            return new AdultJudgeResponse(name + "은(는) 성인입니다.");
        }

        return new AdultJudgeResponse(name + "은(는) 성인이 아닙니다.");
    }
}