package com.xd.controller;

import com.xd.pojo.Student;
import com.xd.service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService service;

    public void setService(StudentService service) {
        this.service = service;
    }

    public void findAll() {
        List<Student> list = service.findAll();
        System.out.println("最终数据为：" + list);
    }
}
