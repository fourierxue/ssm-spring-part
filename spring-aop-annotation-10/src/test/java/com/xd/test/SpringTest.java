package com.xd.test;

import com.xd.config.JavaConfig;
import com.xd.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class SpringTest {
    @Autowired
    private Calculator calculator;
    @Test
    public void test() {
        int result = calculator.add(1,1);
        System.out.println("result = " + result);
        calculator.div(1,0);
    }
}
