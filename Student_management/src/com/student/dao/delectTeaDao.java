package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface delectTeaDao {
    int delectTea(@Param("id") int id);
}
