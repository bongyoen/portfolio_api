package com.co.portfolio_api.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    //Filter에 포함되는 URL 주소
    private static final String[] INCLUDE_PATHS = {
            "/test/*",
            "/info/*",
            "/test2/*"
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(
                        HttpMethod.GET.toString(),
                        HttpMethod.POST.toString(),
                        HttpMethod.PUT.toString(),
                        HttpMethod.PATCH.toString(),
                        HttpMethod.DELETE.toString());

        WebMvcConfigurer.super.addCorsMappings(registry);
    }

    @Bean
    public FilterRegistrationBean filterBean() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new apiFilter());
        registrationBean.setOrder(Integer.MIN_VALUE); //필터 여러개 적용 시 순번
//        registrationBean.addUrlPatterns("/*"); //전체 URL 포함
//        registrationBean.addUrlPatterns("/test/*"); //특정 URL 포함
//        registrationBean.setUrlPatterns(Arrays.asList(INCLUDE_PATHS)); //여러 특정 URL 포함
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
