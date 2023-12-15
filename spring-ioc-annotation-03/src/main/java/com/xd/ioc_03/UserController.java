package com.xd.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    //xml di必须有set方法，autowired注解不用
    // @Qualifier
    // @Resource
    @Autowired
    private UserService userService;
    public void show() {
        userService.show();
    }
}
