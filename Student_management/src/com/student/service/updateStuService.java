package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface updateStuService {
    int updateStu( String username,  String idcard,  String birthdate,  String classId,  String password,int id);

}
