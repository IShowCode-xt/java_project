package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface delectStuDao {
    int delectStu(@Param("id") int id);
}
