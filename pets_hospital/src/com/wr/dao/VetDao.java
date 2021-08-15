package com.wr.dao;

import com.wr.bean.Speciality;
import com.wr.bean.Vet;
import com.wr.util.JDBCUtils;
import com.wr.util.PageInfo;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VetDao {
    private Connection con=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    //获取总页数，count是每页显示的条数
    public int[] totalPage(int count){
        int arr[]=new int[2];
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select count(*) from t_vet");
            while (rs.next()){
                arr[0]=rs.getInt(1);//总记录数
                if(arr[0]%count==0){
                    arr[1]= arr[0]/count;//共有多少页
                }else{
                    arr[1]= arr[0]/count+1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,stmt,con);
        }
        return arr;
    }
    //获取当前页的医生列表
    public  List<Vet> getAllVets(int cpage,int count){
        List<Vet> vets=new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from t_vet order by id limit "+(cpage-1)*count +","+ count;
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Vet vet = new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vet.setTel(rs.getString("tel"));
                vets.add(vet);
            }
            //处理医生专业:存放医生id和专业名称
            Map<Integer,String> vetSpe = this.findVetSpeName(vets);

            //遍历医生集合，将Map<医生id,专业名称>填充到医生集合里面
            for(int i = 0 ; i < vets.size() ; i++){
                Vet vet = vets.get(i);
                String vetSpeName = vetSpe.get(vet.getId());
                vet.setSpecialityStr(vetSpeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  vets;
    }
    //添加医生信息
    public boolean addVet(String name,String tel){
        int count=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count = stmt.executeUpdate("insert into t_vet(`name`,`tel`) values ('" + name + "','" + tel + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count>0;
    }
    //获取用户id
    public int getIdByName(String name){
        int id=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select id from t_vet where name='"+name+"'");
            while (rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    //根据id获取用户信息
    public Vet getVetById(String id){
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from t_vet where id="+id+"");
            while (rs.next()){
                Vet vet=new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vet.setTel(rs.getString("tel"));
                return vet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateVet(String id,String vet_name,String vet_tel){
        int count=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count=stmt.executeUpdate("update t_vet set name='"+vet_name+"',tel='"+vet_tel+"' where id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count>0;
    }
    //根据医生Id删除医生信息
    public boolean deleteVetById(String id){
        int count=0;
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            count=stmt.executeUpdate("delete  from t_vet  where id="+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  count>0;
    }
    //按照姓名查询医生
    public List<Vet> select(String search){
        List<Vet> vets=new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from t_vet where name like'%"+search+"%'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Vet vet = new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vet.setTel(rs.getString("tel"));
                vets.add(vet);
            }
            Map<Integer,String> vetSpe = this.findVetSpeName(vets);
            //遍历医生集合，将Map<医生id,专业名称>填充到医生集合里面
            for(int i = 0 ; i < vets.size() ; i++){
                Vet vet = vets.get(i);
                String vetSpeName = vetSpe.get(vet.getId());
                vet.setSpecialityStr(vetSpeName);
            }
            return vets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vet> selectSpe(String search){
        Map<Integer,Vet> vetMap=new HashMap<>();
        List<Speciality> spes=new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="select * from t_speciality where name like'%"+search+"%'";
            rs=stmt.executeQuery(sql);
            //后面会从这个里面取出专业对象来填充医生里面专业名称
            Map<Integer,Speciality> speMap = new HashMap<>();
            while (rs.next()){
                Speciality spe = new Speciality();
                spe.setId(rs.getInt("id"));
                spe.setName(rs.getString("name"));
                spes.add(spe);
                speMap.put(spe.getId(),spe);
            }
            StringBuffer vetSql = new StringBuffer();
            vetSql.append("SELECT t.id,t.name,t.tel,t1.specId  FROM t_vet t LEFT JOIN t_vet_speciality t1 ON t.id = t1.vetId WHERE t1.specId IN ");
            vetSql.append("(");
            for(int i = 0 ; i < spes.size() ; i++){
                vetSql.append(spes.get(i).getId());
                //如果是最后一个id，那么就用）结尾，否则就再id后面增加，
                if(i == (spes.size()-1)){
                    vetSql.append(")");
                }else {
                    vetSql.append(",");
                }
            }
            System.out.println("查询医生sql："+vetSql.toString());
            rs=stmt.executeQuery(vetSql.toString());
            while (rs.next()){
                Vet vet = new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vet.setTel(rs.getString("tel"));
                Integer specId = rs.getInt("specId");
                String speName = speMap.get(specId).getName();
                //说明当前这个医生有多个专业,那么只需要将专业名拼接再原来医生信息里面即可
                if(vetMap.containsKey(vet.getId())){
                    Vet vetTemp = vetMap.get(vet.getId());
                    String newSpeName = StringUtils.join(vetTemp.getSpecialityStr(),",",speName);
                    vetTemp.setSpecialityStr(newSpeName);
                    vetMap.put(vet.getId(),vetTemp);
                }else{
                    vet.setSpecialityStr(speName);
                    vetMap.put(vet.getId(),vet);
                }
            }
            //将Map结构的医生信息转成List
            List<Vet> vets = new ArrayList<>();
            for(Map.Entry<Integer,Vet> entry : vetMap.entrySet()){
                vets.add(entry.getValue());
            }
            return vets;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int checkTel(String tel) {
        try{
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="select count(1) as countNum from t_vet where tel ='"+tel+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                return rs.getInt("id");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Boolean add(Vet vet) {
        try{
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="INSERT INTO t_vet(NAME,tel)VALUES('"+vet.getName()+"','"+vet.getTel()+"')";
            int count = stmt.executeUpdate(sql);
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

    //专门通过医生信息来查询医生所学的专业。只要是查询类的方法都可以用到
    public Map<Integer,String> findVetSpeName(List<Vet> vets){
        //存放医生id和专业名称
        Map<Integer,String> vetSpe = new HashMap<>();
        try{
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            //处理医生专业
            StringBuffer speSql = new StringBuffer();
            speSql.append("SELECT t.vetId, t1.name FROM t_vet_speciality t LEFT JOIN t_speciality t1  ON t.specId = t1.id where t.vetId IN ");
            speSql.append("(");
            for(int i = 0 ; i < vets.size() ; i++){
                speSql.append(vets.get(i).getId());
                //如果是最后一个id，那么就用）结尾，否则就再id后面增加，
                if(i == (vets.size()-1)){
                    speSql.append(")");
                }else {
                    speSql.append(",");
                }
            }
            System.out.println("查询专业sql："+speSql.toString());

            rs=stmt.executeQuery(speSql.toString());
            while (rs.next()){
                Integer vetId = rs.getInt("vetId");
                String speName = rs.getString("name");
                if(vetSpe.containsKey(vetId)){
                    String vetSpeName = StringUtils.join(vetSpe.get(vetId),",",speName);
                    vetSpe.put(vetId,vetSpeName);
                }else {
                    vetSpe.put(vetId,speName);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vetSpe;
    }

    public List<Vet> getListTest(){
        List<Vet> vList=new ArrayList<Vet>();
        try{
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String sql="SELECT v.*,GROUP_CONCAT(s.`name`) sname FROM t_vet v LEFT JOIN t_vet_speciality vs ON v.`id`=vs.`vetId` LEFT JOIN t_speciality s ON vs.`specId`=s.`id` GROUP BY v.`id`  ORDER BY v.`id`";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Vet vet = new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vet.setTel(rs.getString("tel"));
                vet.setSpecialityStr(rs.getString("sname"));
                vList.add(vet);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return vList;
    }

    public PageInfo<Vet> selectByPage(String queryType,String search, int cpage, int count) {
        List<Vet> vets=new ArrayList<>();
        try {
            con= JDBCUtils.getConnection();//获得连接
            stmt=con.createStatement();//获得Statement对象
            String selectSql="";
            if ("2".equals(queryType)){
                selectSql="where v.name like '%"+search+"%'";
            }else if("3".equals(queryType)){
                selectSql="where s.name like '%"+search+"%'";
            }
            String sql="SELECT v.*,GROUP_CONCAT(s.`name`) sname FROM t_vet v " +
                    "LEFT JOIN t_vet_speciality vs ON v.`id`=vs.`vetId` " +
                    "LEFT JOIN t_speciality s ON vs.`specId`=s.`id` " +
                    selectSql+
                    "GROUP BY v.`id`  ORDER BY v.`id`";
            String countSql ="SELECT COUNT(1) FROM ( "+ sql +") AS tempTable";

            String dataSql = sql +" limit "+(cpage-1)*count +","+ count;
            //分页列表中的数据
            rs=stmt.executeQuery(dataSql);
            while (rs.next()){
                Vet vet = new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                vet.setTel(rs.getString("tel"));
                vet.setSpecialityStr(rs.getString("sname"));
                vets.add(vet);
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
//            Map<Integer,String> vetSpe = this.findVetSpeName(vets);
//            //遍历医生集合，将Map<医生id,专业名称>填充到医生集合里面
//            for(int i = 0 ; i < vets.size() ; i++){
//                Vet vet = vets.get(i);
//                String vetSpeName = vetSpe.get(vet.getId())==null?"":vetSpe.get(vet.getId());
//                vet.setSpecialityStr(vetSpeName);
//            }
            PageInfo<Vet> pageInfo = new PageInfo<>();
            pageInfo.setCpage(cpage);
            pageInfo.setData(vets);
            pageInfo.setTotalNum(totalNum);
            pageInfo.setTotalPage(totalPage);
            return pageInfo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vet> getListVet() {
        List<Vet> list=new ArrayList<Vet>();
        try {
            con=JDBCUtils.getConnection();
            stmt=con.createStatement();
            String sql="select * from t_vet";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Vet vet=new Vet();
                vet.setId(rs.getInt("id"));
                vet.setName(rs.getString("name"));
                list.add(vet);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;
    }
}
