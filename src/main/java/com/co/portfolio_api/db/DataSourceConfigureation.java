package com.co.portfolio_api.db;


import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfigureation {


//    @Primary
//    @Bean
//    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
//        return new LazyConnectionDataSourceProxy(routingDataSource);
//    }
//
//    @Bean
//    public DataSource routingDataSource(@Qualifier("writeOnlyDataSource") DataSource writeDataSource,
//                                        @Qualifier("readOnlyDataSource") DataSource readDataSource) {
//
//
//        RoutingDataSourceImpl routingDataSourceImpl = new RoutingDataSourceImpl();
//        Map<Object, Object> targetDataSource = new HashMap<>();
//        targetDataSource.put("write", writeDataSource);
//        targetDataSource.put("read", readDataSource);
//        routingDataSourceImpl.setTargetDataSources(targetDataSource);
//        routingDataSourceImpl.setDefaultTargetDataSource(writeDataSource);
//
//        return routingDataSourceImpl;
//    }
}
