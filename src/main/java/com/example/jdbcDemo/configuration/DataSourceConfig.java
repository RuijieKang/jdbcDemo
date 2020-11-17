// package com.example.jdbcDemo.configuration;

// import oracle.ucp.jdbc.PoolDataSource;
// import oracle.ucp.jdbc.PoolDataSourceFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;

// import javax.sql.DataSource;
// import java.sql.SQLException;

// @Configuration
// public class DataSourceConfig {
//     @Value("${spring.datasource.url}")
//     private String url;
//     @Value("${spring.datasource.username}")
//     private String username;
//     @Value("${spring.datasource.password}")
//     private String password;
//     @Value("${oracle.ucp.minPoolSize}")
//     private String minPoolSize;

//     @Value("${oracle.ucp.maxPoolSize}")
//     private String maxPoolSize;

//     @Value("${spring.datasource.driver-class-name:oracle.jdbc.pool.OracleDataSource}")
//     private String driverClassName;

//     // @Bean(name = "OracleUniversalConnectionPool")
//     // @Primary
//     @Bean
//     public DataSource getDataSource() {
//         PoolDataSource pds = null;
//         try {
//             pds = PoolDataSourceFactory.getPoolDataSource();

//             pds.setConnectionFactoryClassName(driverClassName);
//             pds.setURL(url);
//             pds.setUser(username);
//             pds.setPassword(password);
//             pds.setMinPoolSize(Integer.valueOf(minPoolSize));
//             pds.setInitialPoolSize(2);
//             pds.setMaxPoolSize(Integer.valueOf(maxPoolSize));

//         } catch (SQLException ea) {
//             System.err.println("Error connecting to the database: " + ea.getMessage());
//         }

//         return pds;
//     }
// }
