package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface delectScoreService {
    int delectScore(@Param("id") String id);
}
