package com.student.service.impl;

import com.student.dao.updatePasswordDao;
import com.student.service.updatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class updatePasswordServiceImpl implements updatePasswordService {
    @Autowired
    private updatePasswordDao updatePasswordDao;
    @Override
    public int updateStuPassword(int id, String password) {
       int s= updatePasswordDao.updateStuPassword(id,password);
        return s;
    }

    @Override
    public int updateTeaPassword(int id, String password) {
        int s=updatePasswordDao.updateTeaPassword(id,password);
        return s;
    }

    @Override
    public int updateAdminPassword(int id, String password) {
        int s=updatePasswordDao.updateAdminPassword(id,password);
        return s;
    }
}
