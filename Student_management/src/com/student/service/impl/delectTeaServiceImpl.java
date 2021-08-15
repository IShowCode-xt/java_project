package com.student.service.impl;

import com.student.dao.delectTeaDao;
import com.student.service.delectTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class delectTeaServiceImpl implements delectTeaService {
    @Autowired
    private delectTeaDao delectTeaDao;
    @Override
    public int delectTea(int id) {
       int row= delectTeaDao.delectTea(id);
        return row;
    }
}
