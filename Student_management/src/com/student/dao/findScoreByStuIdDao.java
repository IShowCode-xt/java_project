package com.student.dao;

import com.student.po.Score;
import com.student.po.Student;
import org.apache.ibatis.annotations.Param;

public interface findScoreByStuIdDao {
    Score findScoreByStuId(@Param("stuId") String stuId);
}
