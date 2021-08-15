package com.wr.dao;

import com.wr.bean.Vet;
import com.wr.bean.Visit;
import com.wr.util.JDBCUtils;
import com.wr.util.PageInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitDao {
    private Connection con=null;
    private Statement stmt=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;
    public PageInfo<Visit> selectByPage(String queryType, String search, int cpage, int count) {
        List<Visit> visits=new ArrayList<Visit>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String selectSql="";
            if ("2".equals(queryType)){
                selectSql="where tp.name like '%"+search+"%'";
            }else if("3".equals(queryType)){
                selectSql="where tv.name like '%"+search+"%'";
            }
            //SELECT tp.name,tv.name,vi.* FROM t_visit vi
            //LEFT JOIN t_pet tp ON vi.petId=tp.id
            //LEFT JOIN t_vet tv ON vi.vetId=tv.id;
            String sql="SELECT tp.name pname,tv.name vname,vi.* FROM t_visit vi LEFT JOIN t_pet tp ON vi.petId=tp.id LEFT JOIN t_vet tv ON vi.vetId=tv.id " + selectSql;
            String countSql ="SELECT COUNT(1) FROM ( "+ sql +") AS tempTable";

            String dataSql = sql +" limit "+(cpage-1)*count +","+ count;
            //分页列表中的数据
            rs=stmt.executeQuery(dataSql);
            while (rs.next()){
                Visit visit=new Visit();
                visit.setId(rs.getInt("id"));//病例ID
                visit.setPetId(rs.getInt("petId"));
                visit.setVetId(rs.getInt("vetId"));
                visit.setVname(rs.getString("vname"));//医师名称
                visit.setPname(rs.getString("pname"));//宠物昵称
                visit.setVisitdate(rs.getString("visitdate"));//就诊日期
                visit.setDescription(rs.getString("description"));//病情描述
                visit.setTreatment(rs.getString("treatment"));//治疗方案
                visits.add(visit);
            }
            //分页总数
            Integer totalPage = 0,totalNum = 0;
            rs=stmt.executeQuery(countSql);
            while (rs.next()){
                totalNum = rs.getInt(1);
                if(totalNum%count==0){
                    totalPage= totalNum/count;//共有多少页
                }else{
                    totalPage= totalNum/count+1;
                }
            }

            PageInfo<Visit> pageInfo = new PageInfo<>();
            pageInfo.setCpage(cpage);
            pageInfo.setData(visits);
            pageInfo.setTotalNum(totalNum);
            pageInfo.setTotalPage(totalPage);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean deleteVisitById(int id){
        int count=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count=stmt.executeUpdate("delete  from t_visit  where id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count>0;
    }
    public boolean toUpdateVisit(String id, String date,String description,String treatment) {
        con= JDBCUtils.getConnection();//获得连接
        int count =0;
        try {
            String sql="UPDATE t_visit SET `visitdate`=?, `description`=?,`treatment`=? WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,date);
            pstm.setString(2,description);
            pstm.setString(3,treatment);
            pstm.setString(4,id);
            count= pstm.executeUpdate();
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //根据id获取用户信息
    public Visit getVisitById(String id){
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT tp.name pname,tv.name vname,vi.* FROM t_visit vi LEFT JOIN t_pet tp ON vi.petId=tp.id LEFT JOIN t_vet tv ON vi.vetId=tv.id where vi.id="+id);
            while (rs.next()){
                Visit visit=new Visit();
                visit.setId(rs.getInt("id"));//病例ID
                visit.setPetId(rs.getInt("petId"));
                visit.setVetId(rs.getInt("vetId"));
                visit.setVname(rs.getString("vname"));//医师名称
                visit.setPname(rs.getString("pname"));//宠物昵称
                visit.setVisitdate(rs.getString("visitdate"));//就诊日期
                visit.setDescription(rs.getString("description"));//病情描述
                visit.setTreatment(rs.getString("treatment"));//治疗方案
                return visit;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertVisit(String pet_id, String vet_id, String visitDate, String description, String treatment) {
        con= JDBCUtils.getConnection();//获得连接
        int count =0;
        try {
            String sql="insert  into `t_visit` (petId,vetId,visitdate,description,treatment) values(?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,pet_id);
            pstm.setString(2,vet_id);
            pstm.setString(3,visitDate);
            pstm.setString(4,description);
            pstm.setString(5,treatment);
            count= pstm.executeUpdate();
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
