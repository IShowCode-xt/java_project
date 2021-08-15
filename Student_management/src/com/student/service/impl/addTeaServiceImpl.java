package com.student.service.impl;

import com.student.dao.addTeaDao;
import com.student.service.addTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class addTeaServiceImpl implements addTeaService {
    @Autowired
    private addTeaDao addTeaDao;
    @Override
    public int addTea(String username, String classId, String password) {
        int rows=addTeaDao.addTea(username,classId,password);
        return rows;
    }
}
