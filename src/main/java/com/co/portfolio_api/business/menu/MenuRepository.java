package com.co.portfolio_api.business.menu;


import com.co.portfolio_api.db.entity.Menu;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.co.portfolio_api.db.entity.QMenu.menu;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final JPAQueryFactory factory;

    public List<Menu> findAllMenu() {
        return factory.selectFrom(menu)
                .fetch();
    }

    public List<String> findAllMenuName() {
        return factory.select(menu.title) //
                .from(menu)
                .orderBy(menu.menuNo.asc())
                .fetch();
    }
}
