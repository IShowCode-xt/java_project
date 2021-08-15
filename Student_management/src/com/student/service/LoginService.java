package com.student.service;

import com.student.po.Admin;
import com.student.po.Student;
import com.student.po.Teacher;
import org.apache.ibatis.annotations.Param;

public interface LoginService {
    public Student findStuByName(String username);
    public Teacher findTeaByName(String username);
    public Admin findAdByName( String username);
}
