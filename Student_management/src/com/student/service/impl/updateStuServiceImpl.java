package com.student.service.impl;

import com.student.dao.updateStuDao;
import com.student.service.updateStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class updateStuServiceImpl implements updateStuService {
    @Autowired
    private updateStuDao updateStuDao;
    @Override
    public int updateStu(String username, String idcard, String birthdate, String classId, String password,int id) {
        int rows=updateStuDao.updateStu(username,idcard,birthdate,classId,password,id);

        return rows;
    }
}
