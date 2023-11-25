package com.co.portfolio_api.business.menu;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MenuDto {

    @Getter
    @Setter
    public static class WebHeaderRslt {
        private List<String> headerNames = new ArrayList<>();
    }
}
