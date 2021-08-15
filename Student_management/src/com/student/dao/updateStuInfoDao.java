package com.student.dao;

import org.apache.ibatis.annotations.Param;

public interface updateStuInfoDao {
    int updateStuInfo(@Param("stu_id") int stu_id, @Param("stu_name") String stu_name, @Param("stu_idC") String stu_idC,@Param("stu_bir") String stu_bir, @Param("stu_class") String stu_class);
}
