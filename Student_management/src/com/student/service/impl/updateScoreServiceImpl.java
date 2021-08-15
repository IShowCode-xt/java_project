package com.student.service.impl;

import com.student.dao.updateScoreDao;
import com.student.service.updateScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class updateScoreServiceImpl implements updateScoreService {
    @Autowired
    private updateScoreDao updateScoreDao;
    @Override
    public int updateScore(String username, String stuCard, int javaw, int javaee, int vue, int russion) {
        int rows=updateScoreDao.updateScore(username,stuCard,javaw,javaee,vue,russion);
        return rows;
    }
}
