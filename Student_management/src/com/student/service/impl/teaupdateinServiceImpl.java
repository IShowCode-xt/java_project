package com.student.service.impl;

import com.student.dao.teaupdateinDao;
import com.student.service.teaupdateinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class teaupdateinServiceImpl implements teaupdateinService {
    @Autowired
    private teaupdateinDao teaupdateinDao;
    @Override
    public int updateIn(int id, String username, String classId) {
        teaupdateinDao.updateIn(id,username,classId);
        return 0;
    }
}
