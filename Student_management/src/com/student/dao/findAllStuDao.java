package com.student.dao;

import com.student.po.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface findAllStuDao {
    List<Student> findAllStu(@Param("username") String username,@Param("idcard") String idcard) ;
    Student findStudent(@Param("id") int id);
}
