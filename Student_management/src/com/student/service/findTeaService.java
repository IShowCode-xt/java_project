package com.student.service;

import com.student.po.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface findTeaService {
    List<Teacher> findTea( String username,  String classId) ;
    Teacher findTeacherById(@Param("id") int id);
}
