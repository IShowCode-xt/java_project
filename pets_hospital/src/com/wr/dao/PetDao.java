package com.wr.dao;

import com.wr.bean.Pet;
import com.wr.util.JDBCUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDao {
    private Connection con=null;
    private Statement stmt=null;
    private PreparedStatement pstm=null;
    private ResultSet rs=null;
    //查询用户拥有的宠物
    public List<Pet> getPetListByUserId(int userId){
        List<Pet> pets=new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from t_pet where ownerId='"+userId+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setBirthdate(rs.getString("birthdate"));
                pet.setPhoto(rs.getString("photo"));
                pet.setOwnerId(rs.getInt("ownerId"));
                pets.add(pet);
            }
            return pets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean savePet(String ownerId, String name, String birthdate,String photo) {
        try{
            con= JDBCUtils.getConnection();//获得连接
            String sql= "INSERT INTO t_pet(name,birthdate,photo,ownerId) VALUES (?,?,?,?)";
            PreparedStatement pstms = con.prepareStatement(sql);
            pstms.setString(1, name);
            pstms.setString(2, birthdate);
            pstms.setString(3, photo);
            pstms.setString(4, ownerId);
            return pstms.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  Boolean.FALSE;
    }

    public boolean updatePet(String id, String ownerId, String name, String birthdate,String photo) {
        try{
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            StringBuffer sql= new StringBuffer();
            sql.append("update t_pet set ")
                    .append("name = ").append("'").append(name).append("',")
                    .append("birthdate = ").append("'").append(birthdate).append("',");
            if(StringUtils.isNotEmpty(photo)){
                sql.append("photo = ").append("'").append(photo).append("',");
            }
            sql.append("ownerId = ").append("'").append(ownerId).append("'")
                    .append("where id = ").append(id);
            System.out.println("更新sql："+sql.toString());
            int count = stmt.executeUpdate(sql.toString());
            if(count > 0){
                return Boolean.TRUE;
            }else {
                return Boolean.FALSE;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  Boolean.FALSE;
    }

    public boolean deletePetById(int petId) {
        int count=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count=stmt.executeUpdate("delete  from t_pet  where id="+petId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count>0;
    }

    public boolean deletePetByUserId(String userId) {
        int count =0;

        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count =stmt.executeUpdate("delete from t_pet where ownerId="+userId);
            return count>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public Pet getPetById(String pet_id) {
        Pet pet=new Pet();
        try {
            con= JDBCUtils.getConnection();//获得连接
            String sql="select * from t_pet where id="+pet_id;
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setBirthdate(rs.getString("birthdate"));
                pet.setPhoto(rs.getString("photo"));
                pet.setOwnerId(rs.getInt("ownerId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  pet;
    }
}
