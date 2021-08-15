package com.student.service.impl;

import com.student.dao.findTeaDao;
import com.student.po.Teacher;
import com.student.service.findTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class findTeaServiceImpl implements findTeaService {
    @Autowired
    private findTeaDao findTeaDao;
    @Override
    public List<Teacher> findTea(String username, String classId) {
        List<Teacher> list=findTeaDao.findTea(username,classId);
        return list;
    }

    @Override
    public Teacher findTeacherById(int id) {
        Teacher teacher=findTeaDao.findTeacherById(id);
        return teacher;
    }
}
