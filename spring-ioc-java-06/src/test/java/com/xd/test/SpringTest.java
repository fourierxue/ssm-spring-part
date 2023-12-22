package com.xd.test;

import com.xd.config.JavaConfiguration;
import com.xd.config.JavaConfigurationA;
import com.xd.config.JavaConfigurationB;
import com.xd.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController bean = ac.getBean(StudentController.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void test_04() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfigurationA.class, JavaConfigurationB.class);
        //配置类A中使用@Import注解引用B之后，只需要读取A
        ApplicationContext ac1 = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
