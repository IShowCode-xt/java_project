package com.student.service.impl;

import com.student.dao.LoginDao;
import com.student.po.Admin;
import com.student.po.Student;
import com.student.po.Teacher;
import com.student.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Student findStuByName(String username) {
        Student st=loginDao.findStuByName(username);
        return st;
    }

    @Override
    public Teacher findTeaByName(String username) {
        Teacher te=loginDao.findTeaByName(username);
        return te;
    }

    @Override
    public Admin findAdByName(String username) {
        Admin ad=loginDao.findAdByName(username);
        return ad;
    }
}
