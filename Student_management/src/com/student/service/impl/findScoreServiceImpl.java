package com.student.service.impl;

import com.student.dao.findScoreDao;
import com.student.po.Score;
import com.student.service.findScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class findScoreServiceImpl implements findScoreService {
    @Autowired
    private findScoreDao findScoreDao;
    @Override
    public List<Score> findScore(String username, String idcard) {
        List<Score> list=findScoreDao.findScore(username,idcard);
        return list;
    }

    @Override
    public Score findScoreByStuId(String stuCard) {
        Score score=findScoreDao.findScoreByStuId(stuCard);
        return score;
    }
}
