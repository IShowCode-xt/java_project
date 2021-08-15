package com.wr.dao;

import com.wr.bean.Speciality;
import com.wr.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取专业名称
 */
public class SpecialityDao {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public List<Speciality> getAllSpecialitys() {
        List<Speciality> spList = new ArrayList<Speciality>();
        try {
            con = JDBCUtils.getConnection();
            stmt = con.createStatement();
            //查询所有医生专业
            rs = stmt.executeQuery("select * from t_speciality order by id");
            while (rs.next()) {
                Speciality sp = new Speciality();
                sp.setId(rs.getInt("id"));
                sp.setName(rs.getString("name"));
                spList.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return spList;
    }

    public boolean addVetSpeciality(int vetId, String[] specialiyts) {
        int count=0;
        try {
            con = JDBCUtils.getConnection();
            stmt = con.createStatement();
            //添加医生和专业信息
            StringBuffer sql = new StringBuffer();
            sql.append("insert into t_vet_speciality(vetId,specId) values (");
            for (int i=0;i<specialiyts.length;i++){
                sql.append(vetId+","+specialiyts[i]+")");
                if (i<specialiyts.length-1){
                    sql.append(",(");
                }
            }
            System.out.println(sql);
            count=stmt.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count>0;
    }
    public boolean deleteVetSpeciality(String vetId){
        int count=0;
        try {
            con = JDBCUtils.getConnection();
            stmt = con.createStatement();
            String  sql="delete from t_vet_speciality where vetId="+vetId;
            count=stmt.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count>0;
    }
}
