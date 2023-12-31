package com.co.portfolio_api.db;


import com.zaxxer.hikari.HikariDataSource;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Slf4j
@ConfigurationProperties(prefix = "spring.datasource")
@Validated
@Setter
public class DataSourceConfig {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String url;
    @NotNull
    private String endpoint;
    @NotNull
    private Integer port;

    private final SshTunnelingInit initializer;


    public DataSourceConfig(SshTunnelingInit initializer) {
        this.initializer = initializer;
    }

    @Bean
    public DataSource dataSource() {

        if (initializer == null) {
            return DataSourceBuilder.create()
                    .driverClassName("org.postgresql.Driver")
                    .url(url)
                    .username(username)
                    .password(password)
                    .type(HikariDataSource.class)
                    .build();
        }


        Integer forwardedPort = initializer.buildSshDbConnection(endpoint, port, 20001);  // ssh 연결 및 터널링 설정

        log.info("url : {} {} {} {}", url, username, password, forwardedPort);

        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(url.replace("[forwardedPort]", Integer.toString(forwardedPort)))
                .username(username)
                .password(password)
                .type(HikariDataSource.class)
                .build();


    }
}
