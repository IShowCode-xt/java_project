package com.student.service.impl;

import com.student.dao.delectScoreDao;
import com.student.service.delectScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class delectScoreServiceImpl implements delectScoreService {
    @Autowired
    private delectScoreDao delectScoreDao;
    @Override
    public int delectScore(String id) {
        int rows=delectScoreDao.delectScore(id);
        return rows;
    }
}
