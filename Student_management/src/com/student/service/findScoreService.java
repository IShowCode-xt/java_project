package com.student.service;

import com.student.po.Score;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface findScoreService {
    List<Score> findScore(String username, String idcard) ;
    Score findScoreByStuId( String stuCard);
}
