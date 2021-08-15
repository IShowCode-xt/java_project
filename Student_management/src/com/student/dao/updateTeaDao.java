package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface updateTeaDao {
    int updateTea(@Param("username") String username, @Param("classId") String classId,  @Param("password") String password, @Param("id") int id);

}
