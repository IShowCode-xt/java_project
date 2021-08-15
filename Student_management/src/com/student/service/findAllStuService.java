package com.student.service;

import com.student.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface findAllStuService {
    List<Student> findAllStu(String username,String idcard) ;
    Student findStudent( int id);
}
