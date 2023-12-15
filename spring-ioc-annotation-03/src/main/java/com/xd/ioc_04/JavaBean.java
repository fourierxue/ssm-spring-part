package com.xd.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    private String name = "xxx"; //直接赋值
    @Value("19")
    private String age; //注解赋值，主要用于读取配置文件，字面量可以直接赋值
    @Value("${username:admin}")
    private String username;// :后为默认值
    @Value("${password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
