package com.student.service;

public interface updatePasswordService {
    int updateStuPassword(int id,String password);
    int updateTeaPassword(int id,String password);
    int updateAdminPassword(int id,String password);
}
