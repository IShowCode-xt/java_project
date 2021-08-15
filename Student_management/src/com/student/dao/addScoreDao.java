package com.student.dao;
import org.apache.ibatis.annotations.Param;


public interface addScoreDao {
    int addScore(@Param("username") String username, @Param("stucard") String stucard, @Param("javaw") int javaw, @Param("javaee") int javaee, @Param("vue") int vue,@Param("russion") int russion) ;
}
