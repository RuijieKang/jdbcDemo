package com.example.jdbcDemo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration  
public class DataSourceConfigOracle {
    @Bean
    @ConfigurationProperties("oracle.datasource")
    public DataSourceProperties dataSourcePropertiesOracle() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("oracle.datasource")
    public HikariDataSource dataSourceOracle() {
        return dataSourcePropertiesOracle()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "TransactionManagerOracle")
    @Primary
    DataSourceTransactionManager dataSourceTransactionManagerOracle() {
        DataSourceTransactionManager manager  = new DataSourceTransactionManager(dataSourceOracle());
        return manager;
    }

    // @Bean(name = "DataSourceOracle")
    // @ConfigurationProperties("oracle.datasource")
    // public DataSource dataSource(){
    //     return DataSourceBuilder.create().build();
    // }    
}
