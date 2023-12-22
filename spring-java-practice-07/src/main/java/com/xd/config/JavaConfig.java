package com.xd.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.xd")
@Configuration
public class JavaConfig {
    @Bean
    public DataSource dataSource(@Value("${com.xd.url}") String url,
                                 @Value("${com.xd.driver}") String driver,
                                 @Value("${com.xd.username}") String username,
                                 @Value("${com.xd.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource source) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(source);
        return jdbcTemplate;
    }
}
