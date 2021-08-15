package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface updatePasswordDao {
    int updateStuPassword(@Param("id") int id, @Param("password")String password);
    int updateTeaPassword(@Param("id") int id, @Param("password")String password);
    int updateAdminPassword(@Param("id") int id, @Param("password")String password);
}
