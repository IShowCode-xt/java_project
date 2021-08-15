package com.student.dao;

import com.student.po.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface findScoreDao {
    List<Score> findScore(@Param("username") String username, @Param("idcard") String idcard) ;
    Score findScoreByStuId(@Param("stuCard") String stuCard);
}
