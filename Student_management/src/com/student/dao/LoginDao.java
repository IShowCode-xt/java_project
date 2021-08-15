package com.student.dao;

import com.student.po.Admin;
import com.student.po.Student;
import com.student.po.Teacher;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {
    public Student findStuByName(@Param("username") String username);
    public Teacher findTeaByName(@Param("username") String username);
    public Admin findAdByName(@Param("username") String username);
}
