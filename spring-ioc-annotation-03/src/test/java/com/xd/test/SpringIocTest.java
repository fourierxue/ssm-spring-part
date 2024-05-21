package com.xd.test;

import com.xd.ioc_01.XxlDao;
import com.xd.ioc_03.UserService;
import com.xd.ioc_03.UserServiceImpl;
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
    public void testIoc_03() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-03.xml");
        //Object obj = ac.getBean("userService");
        Object obj1 = ac.getBean("userServiceImpl");
        Object obj2 = ac.getBean(UserService.class);
        Object obj3 = ac.getBean(UserServiceImpl.class);
        System.out.println(obj1);
    }

    @Test
    public void testIoc_04() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-04.xml");
        JavaBean j = ac.getBean(JavaBean.class);
        System.out.println(j);
    }
}
