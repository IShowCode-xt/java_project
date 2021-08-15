package com.wr.util;


import java.sql.*;
public class JDBCUtils {
    //加载驱动，建立数据库连接
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/petshospital?serverTimezone=UTC&characterEncoding=utf-8";
            String username="root";
            String password="6235290";
            con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  con;
    }
    //关闭数据库连接，释放资源
    public static void release(Statement stmt,Connection con){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt=null;
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con=null;
        }
    }
    public static void release(ResultSet rs, Statement stmt, Connection con){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs=null;
        }
      release(stmt,con);
    }
}
