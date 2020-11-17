package com.example.jdbcDemo.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataSourceConfigH2 {
    @Bean
    @Primary
    @ConfigurationProperties("h2.datasource")
    public DataSourceProperties dataSourcePropertiesH2() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("h2.datasource")
    public HikariDataSource dataSourceH2() {
        return dataSourcePropertiesH2()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public DataSourceInitializer dataSourceInitializerH2() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("schema-h2.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("data-h2.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSourceH2());
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
        return dataSourceInitializer;
    }

    @Bean(name = "TransactionManagerH2")
    @Primary
    DataSourceTransactionManager dataSourceTransactionManagerH2() {
        DataSourceTransactionManager manager  = new DataSourceTransactionManager(dataSourceH2());
        return manager;
    }

    // @Bean(name = "DataSourceH2")
    // @ConfigurationProperties("h2.datasource")
    // @Primary
    // public DataSource dataSource(){
    //     return DataSourceBuilder.create().build();
    // }    
}


