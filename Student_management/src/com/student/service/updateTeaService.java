package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface updateTeaService {
    int updateTea(@Param("username") String username, @Param("classId") String classId, @Param("password") String password, @Param("id") int id);
}
