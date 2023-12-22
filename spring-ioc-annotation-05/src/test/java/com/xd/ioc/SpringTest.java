package com.xd.ioc;

import com.xd.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void testThreeLayer() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentController controller = applicationContext.getBean("studentController", StudentController.class);
        controller.findAll();
        applicationContext.close();
    }
}
