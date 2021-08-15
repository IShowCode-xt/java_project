package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface delectScoreDao {
    int delectScore(@Param("id") String id);
}
