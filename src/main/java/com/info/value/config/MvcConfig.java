package com.info.value.config;

import com.info.value.dao.CurrencyDAO;
import com.info.value.dao.CurrencyDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages="com.info.value")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resol = new InternalResourceViewResolver();
        resol.setPrefix("/html/");
        resol.setSuffix(".jsp");
        return resol;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/MySQL");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        return dataSource;
    }

    @Bean
    public CurrencyDAO getCurrencyDAO() {
        return new CurrencyDAOImpl(getDataSource());
    }
}
