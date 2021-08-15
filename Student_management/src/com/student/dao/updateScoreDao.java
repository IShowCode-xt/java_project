package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface updateScoreDao {
    int updateScore(@Param("username")String username,@Param("stuCard")String stuCard,@Param("javaw")int javaw,@Param("javaee")int javaee,@Param("vue")int vue,@Param("russion")int russion);
}
