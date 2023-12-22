package com.xd.controller;

import com.xd.pojo.Student;
import com.xd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService service;

    public void findAll() {
        List<Student> list = service.findAll();
        System.out.println("最终数据为：" + list);
    }
}
