package com.xd.test;

import com.xd.ioc_01.XxlDao;
import com.xd.ioc_04.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void testIoc_01() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-01.xml");
        XxlDao xxlDao = ac.getBean(XxlDao.class);
        System.out.println(xxlDao);
    }

    @Test
    public void testIoc_04() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-04.xml");
        JavaBean j = ac.getBean(JavaBean.class);
        System.out.println(j);
    }
}
