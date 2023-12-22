package com.xd.test;

import com.xd.component.A;
import com.xd.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@SpringJUnitConfig(locations = "指定配置文件")
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringTest {
    @Autowired
    private A a;
    @Test
    public void test() {
        System.out.println(a);
    }
}
