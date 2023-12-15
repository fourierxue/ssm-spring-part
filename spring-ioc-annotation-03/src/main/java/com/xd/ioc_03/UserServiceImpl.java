package com.xd.ioc_03;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void show() {
        System.out.println("show");
    }
}
