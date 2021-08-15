package com.student.service.impl;

import com.student.dao.addScoreDao;
import com.student.service.addScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class addScoreServiceImpl implements addScoreService {
    @Autowired
    private addScoreDao addScoreDao;
    @Override
    public int addScore(String username, String stucard, int javaw, int javaee, int vue, int russion) {
        int rows=addScoreDao.addScore(username,stucard,javaw,javaee,vue,russion);
        return rows;
    }
}
