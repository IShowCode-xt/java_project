package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface updateScoreService {
    int updateScore(String username, String stuCard,int javaw, int javaee, int vue, int russion);
}
