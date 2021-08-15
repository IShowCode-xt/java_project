package com.student.dao;
import com.student.po.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface findTeaDao {
    List<Teacher> findTea(@Param("username") String username, @Param("classId") String classId) ;
    Teacher findTeacherById(@Param("id") int id);
}
