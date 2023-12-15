package com.xd.ioc_02;

public class UserService {
    private UserDao userDao;

    private int age;

    private String name;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserService(int age, String name, UserDao userDao) {
        this.age = age;
        this.name = name;
        this.userDao = userDao;
    }
}
