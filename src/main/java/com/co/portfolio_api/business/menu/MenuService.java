package com.co.portfolio_api.business.menu;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository repository;

    public MenuDto.WebHeaderRslt getWebHeaders() {
        MenuDto.WebHeaderRslt res = new MenuDto.WebHeaderRslt();

        res.setHeaderNames(repository.findAllMenuName());

        return res;
    }
}
