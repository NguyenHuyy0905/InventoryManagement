//package com.nvhuy.inventoryproject.config;
//
//import com.nvhuy.inventoryproject.config.properties.DatasourceProperties;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import jakarta.persistence.EntityManagerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DbConfig {
//    private Logger logger = LogManager.getLogger(DbConfig.class);
//
//    @Autowired
//    private DatasourceProperties dbProps;
//
//    @Bean
//    public DataSource initDataSource() {
//        HikariConfig hikariConfig = new HikariConfig();
//
//        try {
//            hikariConfig.setDriverClassName(dbProps.getDriverClassName());
//            hikariConfig.setJdbcUrl(dbProps.getUrl());
//            hikariConfig.setUsername(dbProps.getUsername());
//            hikariConfig.setPassword(dbProps.getPassword());
//
//            hikariConfig.setAutoCommit(true);
//            hikariConfig.setConnectionTestQuery("Select 1");
//            hikariConfig.setMaximumPoolSize(10);
//            hikariConfig.setValidationTimeout(120);
//            hikariConfig.setMinimumIdle(3);
//            hikariConfig.setMaxLifetime(300000);
//            hikariConfig.setIdleTimeout(60000);
//            hikariConfig.setLeakDetectionThreshold(30000);
//        } catch (Exception ex) {
//            logger.error("Load db config failed, ", ex.getMessage(), ex);
//        }
//
//        return new HikariDataSource(hikariConfig);
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(Database.MYSQL);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("");
//        factory.setDataSource(dataSource);
//        return factory.getObject();
//    }
//}
