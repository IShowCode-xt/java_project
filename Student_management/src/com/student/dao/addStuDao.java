package com.student.dao;
import org.apache.ibatis.annotations.Param;


public interface addStuDao {
    int addStu(@Param("username") String username, @Param("idcard") String idcard,@Param("birthdate") String birthdate,@Param("classId") String classId,@Param("password") String password) ;
}
