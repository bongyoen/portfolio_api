package com.co.portfolio_api.business.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceDto {
    @Getter
    @Setter
    public static class ResourceCond {
        String name;
        String extension;
    }

    @Getter
    @Setter
    public static class ResourceRslt {
        String name;
        String preSingedUrl;
    }
}
