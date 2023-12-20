package com.co.portfolio_api.db.function;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

public class CustomPostgreSQLDialect extends PostgreSQL10Dialect {

    public CustomPostgreSQLDialect() {
        super();
        this.registerFunction("JSON_AGG", new StandardSQLFunction("JSON_AGG", new StringType()));
        this.registerFunction("JSON_BUILD_ARRAY", new StandardSQLFunction("JSON_BUILD_ARRAY", new StringType()));
    }
}
