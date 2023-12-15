package com.xd.test;

import com.xd.ioc_01.HappyComponent;
import com.xd.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    public void createIoc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
    }

    @Test
    public void getBeanFromIoc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-01.xml");
        applicationContext.refresh();
        // 1、直接根据bean id获取
        HappyComponent o = (HappyComponent) applicationContext.getBean("happyComponent");
        // 2、根据bean id，同时指定类型 class
        HappyComponent happyComponent = applicationContext.getBean("happyComponent", HappyComponent.class);
        // 3、直接根据类型获取
        // 根据bean类型获取，前提是ioc容器中该类型bean只能有一个，如果存在多个，会报异常
        // ioc的配置一定是实现类，但是也可以通过接口获取bean instanceof
        HappyComponent happyComponent1 = applicationContext.getBean(HappyComponent.class);
        happyComponent1.doWork();
        System.out.println(o == happyComponent);
        System.out.println(o == happyComponent1);
    }
    @Test
    public void test_04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        // 正常结束ioc容器，否则不会调用destory-method
        applicationContext.close();
    }

    @Test
    public void test_05() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");
        JavaBean javaBean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("javaBean" + javaBean);
        Object factoryBean = applicationContext.getBean("&javaBean");
        System.out.println(factoryBean);
        // 正常结束ioc容器，否则不会调用destory-method
        applicationContext.close();
    }
}
