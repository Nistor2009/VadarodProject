package com.example.VadarodProject.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.example.VadarodProject")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(value = "com.example.VadarodProject.repository", transactionManagerRef = "transactionManager")
public class DatabaseConfig {

    @Value("jdbc:postgresql://localhost:5432/VadarodProject")
    private String url;
    @Value("org.postgresql.Driver")
    private String driver;
    @Value("com.example.VadarodProject")
    private String packagesToScan;
    @Value("org.hibernate.dialect.PostgreSQLDialect")
    private String dialect;
    @Value("true")
    private String showSql;
    @Value("true")
    private String formatSql;
    @Value("update")
    private String hdm2ddl;
    @Value("postgres")
    private String login;
    @Value("1322")
    private String pass;


    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driver);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(login);
        hikariConfig.setPassword(pass);
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.hdm2ddl.auto", hdm2ddl);
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan(packagesToScan);
        factoryBean.setJpaProperties(properties());
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factoryBean().getObject());
        return transactionManager;
    }
}
