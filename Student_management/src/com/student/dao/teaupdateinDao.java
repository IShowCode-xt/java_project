package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface teaupdateinDao {
    int updateIn(@Param("id") int id ,@Param("username") String username,@Param("classId") String classId);
}
