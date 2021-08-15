package com.student.service.impl;

import com.student.dao.updateStuInfoDao;
import com.student.service.updateStuIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class updateStuIServiceImpl implements updateStuIService {
    @Autowired
    updateStuInfoDao updateStuInfoDao;
    @Override
    public int updateStuInfo(int stu_id, String stu_name, String stu_idC, String stu_bir, String stu_class) {
      int s=  updateStuInfoDao.updateStuInfo(stu_id,stu_name,stu_idC,stu_bir,stu_class);
        return s;
    }
}
