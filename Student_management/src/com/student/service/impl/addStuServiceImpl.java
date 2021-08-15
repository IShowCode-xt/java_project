package com.student.service.impl;

import com.student.dao.addStuDao;
import com.student.service.addStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class addStuServiceImpl implements addStuService {
    @Autowired
    private addStuDao addStuDao;
    @Override
    public int addStu(String username, String idcard, String birthdate, String classId, String password) {
        int rows=addStuDao.addStu(username,idcard,birthdate,classId,password);
        return rows;
    }
}
