package com.student.dao;
import org.apache.ibatis.annotations.Param;


public interface addTeaDao {
    int addTea(@Param("username") String username, @Param("classId") String classId, @Param("password") String password) ;
}
