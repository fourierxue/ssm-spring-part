package com.xd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.xd") //配置类可以不扫描，其他的service、advice等都需要扫描
@EnableAspectJAutoProxy //等同配置文件<aop:aspectj-autoproxy/>
public class JavaConfig {
}
