package com.xd.test;

import com.xd.config.JavaConfig;
import com.xd.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController bean = ac.getBean(StudentController.class);
        bean.findAll();
    }
}
