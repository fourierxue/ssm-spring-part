package com.xd.test;

import com.xd.config.JavaConfig;
import com.xd.service.StudentService;
import com.xd.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void  testTx() throws FileNotFoundException {
        //studentService.changeInfo();
        topService.topService();
    }
}