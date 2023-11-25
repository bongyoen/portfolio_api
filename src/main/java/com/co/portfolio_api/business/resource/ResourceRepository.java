package com.co.portfolio_api.business.resource;

import com.co.portfolio_api.db.entity.Resource;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import static com.co.portfolio_api.db.entity.QResource.resource;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ResourceRepository {
    private final JPAQueryFactory factory;

    public Resource findByName(String name) {
        return factory.selectFrom(resource)
                .where(resource.name.eq(name))
                .fetchOne();
    }

    private BooleanExpression eqName(String name) {
        if (StringUtils.hasText(name)) {
            return null;
        }
        return resource.name.eq(name);
    }
}
