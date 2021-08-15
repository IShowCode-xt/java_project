package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface teaupdateinService {
    int updateIn(@Param("id") int id , @Param("username") String username, @Param("classId") String classId);
}
