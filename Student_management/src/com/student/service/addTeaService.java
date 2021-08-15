package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface addTeaService {
    int addTea(String username,  String classId,String password) ;
}
