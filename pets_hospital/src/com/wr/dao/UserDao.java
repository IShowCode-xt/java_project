package com.wr.dao;

import com.wr.bean.User;
import com.wr.util.JDBCUtils;
import com.wr.util.PageInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection con=null;
    private Statement stmt=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;
    //用户登录，查找用户
    public User getByName(String name){
        User user=new User();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from users where name='"+name+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询所有用户
    public List<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        con= JDBCUtils.getConnection();//获得连接
        try {
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from users";
            rs=stmt.executeQuery(sql);
            User user=null;
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    //用户匹配查找
    public List<User> getAllUsers(String str){
        ArrayList<User> users = new ArrayList<>();
        con= JDBCUtils.getConnection();//获得连接
        try {
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from users like '%"+str+"%'";
            rs=stmt.executeQuery(sql);
            User user=null;
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    //修改密码
    public boolean updatePassword(String name,String newpassword){
        con= JDBCUtils.getConnection();//获得连接
        try {
            String sql="update users set password=? where name='"+name+"'";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,newpassword);
            return  pstm.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public PageInfo<User> selectByPage(String queryType, String search, int cpage, int count) {
        List<User> users=new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String selectSql="";
            if ("2".equals(queryType)){
                selectSql="where u.name like '%"+search+"%'";
            }else if("3".equals(queryType)){
                selectSql="where u.tel like '%"+search+"%'";
            }
            String sql="SELECT * FROM users u " + selectSql;
            String countSql ="SELECT COUNT(1) FROM ( "+ sql +") AS tempTable";

            String dataSql = sql +" limit "+(cpage-1)*count +","+ count;
            //分页列表中的数据
            rs=stmt.executeQuery(dataSql);
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setRoleId(rs.getInt("roleId"));
                user.setPassword(rs.getString("password"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                users.add(user);
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

            PageInfo<User> pageInfo = new PageInfo<>();
            pageInfo.setCpage(cpage);
            pageInfo.setData(users);
            pageInfo.setTotalNum(totalNum);
            pageInfo.setTotalPage(totalPage);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean toAddUser(String user_name, String user_tel, String user_address) {
        try {
            con= JDBCUtils.getConnection();//获得连接
            String sql="insert into users(`name`,`roleId`,`password`,`tel`,`address`) values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,user_name);
            pstm.setInt(2, 2);//普通用户角色
            pstm.setString(3,"123456");
            pstm.setString(4,user_tel);
            pstm.setString(5,user_address);
            return pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getVetById(String userId) {
        User user=new User();
        try {
            con= JDBCUtils.getConnection();//获得连接
            String sql="select * from users where id="+userId;
           stmt=con.createStatement();
           rs=stmt.executeQuery(sql);
           while (rs.next()){
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
               user.setRoleId(rs.getInt("roleId"));
               user.setPassword(rs.getString("password"));
               user.setTel(rs.getString("tel"));
               user.setAddress(rs.getString("address"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
//  修改用户信息
    public boolean toUpdateUser(String user_id, String user_name, String user_tel, String user_address) {
        int count=0;
        con= JDBCUtils.getConnection();//获得连接
        try {
            String sql="UPDATE users SET `name`=?, `tel`=?,`address`=? WHERE `id`=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1,user_name);
            pstm.setString(2,user_tel);
            pstm.setString(3,user_address);
            pstm.setString(4,user_id);
            count= pstm.executeUpdate();
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUserById(String userId) {
        int count =0;
        con=JDBCUtils.getConnection();
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count=stmt.executeUpdate("delete  from users  where id="+userId);
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }
}
