package com.student.service;

import org.apache.ibatis.annotations.Param;

public interface addScoreService {
    int addScore( String username,  String stucard, int javaw,  int javaee, int vue, int russion) ;
}
