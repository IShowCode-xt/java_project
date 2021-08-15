package com.student.service.impl;

import com.student.dao.updateTeaDao;
import com.student.service.updateTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class updateTeaServiceImpl implements updateTeaService {
    @Autowired
    private updateTeaDao updateTeaDao;
    @Override
    public int updateTea(String username, String classId, String password, int id) {
        int rows=updateTeaDao.updateTea(username,classId,password,id);
        return rows;
    }
}
