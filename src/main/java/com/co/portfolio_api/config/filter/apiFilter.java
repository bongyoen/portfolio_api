package com.co.portfolio_api.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@WebFilter(urlPatterns = {"/test/*", "/test2/*", "/info/*"})
public class apiFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("---필터 인스턴스 초기화---");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();

//        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*");
//        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
//        ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers",
//                "Origin, X-Api-Key, X-Requested-With, Content-Type, Accept, Authorization");
        log.info("---Request(" + requestURI + ") 필터---");
        chain.doFilter(request, response);
        log.info("---Response(" + requestURI + ") 필터---");
    }

    @Override
    public void destroy() {
        log.info("---필터 인스턴스 종료---");
        Filter.super.destroy();
    }
}
