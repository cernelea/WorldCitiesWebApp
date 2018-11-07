package com.cernelea.config;


//import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.cernelea")
@PropertySource("classpath:configuration.properties")

public class AppConfig {

    @Autowired
    private Environment environment;


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;


    }


    @Bean
    public DriverManagerDataSource dataSource() {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));


        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));


        dataSource.setConnectionProperties(getConnectionProperties());


        return dataSource;
    }


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(getHibernateProperties());
        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));


        return sessionFactory;


    }

    @Autowired
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;


    }


    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        return properties;


    }


    private int getIntProperty(String propertyName) {
        String propertyValue = environment.getProperty(propertyName);
        int intPropertyValue = Integer.parseInt(propertyValue);

        return intPropertyValue;


    }


    private Properties getConnectionProperties() {
        Properties properties = new Properties();
        properties.setProperty("connection.pool.initialPoolSize", environment.getProperty("connection.pool.initialPoolSize"));
        properties.setProperty("connection.pool.minPoolSize", environment.getProperty("connection.pool.minPoolSize"));
        properties.setProperty("connection.pool.maxPoolSize", environment.getProperty("connection.pool.maxPoolSize"));
        properties.setProperty("connection.pool.maxIdleTime", environment.getProperty("connection.pool.maxIdleTime"));
        return properties;


    }


}
