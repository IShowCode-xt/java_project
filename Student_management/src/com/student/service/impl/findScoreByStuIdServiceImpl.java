package com.student.service.impl;

import com.student.dao.findScoreByStuIdDao;
import com.student.po.Score;
import com.student.service.findScoreByStuIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class findScoreByStuIdServiceImpl implements findScoreByStuIdService {
    @Autowired
    private findScoreByStuIdDao findScoreByStuIdDao;
    @Override
    public Score findScoreByStuId(String stuId) {
        Score score=findScoreByStuIdDao.findScoreByStuId(stuId);
        return score;
    }
}
