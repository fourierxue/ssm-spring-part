package com.xd.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * java配置类，替代xml配置文件
 * 1、包扫描
 * 2、引用外部的配置文件文件
 * 3、声明第三方依赖的bean组件
 */
@PropertySource(value = "classpath:jdbc.properties")
@ComponentScan("com.xd.ioc_01")
//@ComponentScan({"com.com.xd.ioc_01", "com.com.xd.ioc_02"}) 多个逗号分隔
@Configuration
public class JavaConfiguration {
    /**
     * @Value注解也可以用于方法的形参列表
     * public DataSource dataSource(@value("${com.xd.url}")){}
     */
    @Value("${xd.url}")
    private String url;
    @Value("${xd.driver}")
    private String driver;
    @Value("${xd.username}")
    private String username;
    @Value("${xd.password}")
    private String password;

    /**
     * beanName默认为方法名 可以用 name或者value属性配置
     * 周期方法
     *      方法1、原有注解 @PostContruct @PreDestory
     *      方法2、initMethod destoryMethod指定
     * 作用域 @Scope指定
     * 如何引用其他的ioc组件
     * @return
     */
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(name = "dataSource1")
    public DataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        /**
         * 引用其他的ioc组件
         * 方案1、如果其他组件也是@bean注解的方法，可以直接使用
         */
        jdbcTemplate.setDataSource(dataSource1());
        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource dataSource1, DataSource dataSource2) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        /**
         * 引用其他的ioc组件
         * 方案2、形参列表声明想要的组件类型，ioc容器也会注入，
         * 要求必须有该类型的bean，没有会报错
         * 如果有多个，会注入beanName等于形参名的bean
         */
        jdbcTemplate.setDataSource(dataSource1);
        return jdbcTemplate;
    }
}
