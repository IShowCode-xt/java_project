package com.student.service.impl;

import com.student.dao.findAllStuDao;
import com.student.po.Student;
import com.student.service.findAllStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class findAllStuServiceImpl implements findAllStuService {
    @Autowired
    private findAllStuDao  findAllStuDao;

    @Override
    public List<Student> findAllStu(String username, String idcard) {
        List<Student> students=findAllStuDao.findAllStu(username,idcard);
        return students;
    }

    @Override
    public Student findStudent(int id) {
        Student student=findAllStuDao.findStudent(id);
        return student;
    }
}
