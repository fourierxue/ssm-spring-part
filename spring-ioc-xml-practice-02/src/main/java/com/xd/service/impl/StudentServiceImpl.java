package com.xd.service.impl;

import com.xd.dao.StudentDao;
import com.xd.pojo.Student;
import com.xd.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.queryAll();
    }
}
