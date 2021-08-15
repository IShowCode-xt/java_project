package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface addStuService {
    int addStu( String username,  String idcard,  String birthdate, String classId,  String password) ;
}
