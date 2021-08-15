package com.student.service.impl;

import com.student.dao.delectStuDao;
import com.student.service.delectStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class delectStuServiceImpl implements delectStuService {
    @Autowired
    private delectStuDao delectStuDao;
    @Override
    public int delectStu(int id) {
        int rows=delectStuDao.delectStu(id);
        return rows;
    }
}
