package com.java.dao;


import com.java.model.Admin;
import com.java.util.BusinessException;
import com.java.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {

    public Admin login(Connection conn,Admin admin) throws Exception{
        Admin resultAdmin=null;
        String sql="select * from admin where account=? and password=?";
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1,admin.getAccount());
        pst.setString(2, admin.getPassword());
        ResultSet rs=pst.executeQuery();
        if(rs.next()) {
            resultAdmin=new Admin();
            resultAdmin.setId(rs.getInt("id"));
            resultAdmin.setAccount(rs.getString("account"));
            resultAdmin.setPassword(rs.getString("password"));
            resultAdmin.setPhone(rs.getString("phone"));
            resultAdmin.setName(rs.getString("name"));
        }
        return resultAdmin;
    }

    public ResultSet list(Connection conn,Admin admin)throws Exception{
        StringBuffer sb=new StringBuffer("select * from admin");
        if(admin.getId()!=0) {
            sb.append(" and id='"+admin.getId()+"' ");
        }
        if(!StringUtil.isEmpty(admin.getAccount())) {
            sb.append(" and account like '%"+admin.getAccount()+"%' ");
        }
        if(!StringUtil.isEmpty(admin.getPassword())) {
            sb.append(" and password='"+admin.getPassword()+"' ");
        }
        if(!StringUtil.isEmpty(admin.getName())) {
            sb.append(" and name='"+admin.getName()+"' ");
        }
        PreparedStatement pst=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
        ResultSet rs=pst.executeQuery();
        return rs;
    }

    public int updatebynum(Connection conn, Admin admin) throws Exception{
        String sql="update admin set id=?,account=?,password=?,phone = ?,name=? where id=?";
        PreparedStatement pst= conn.prepareStatement(sql);
        pst.setInt(1, admin.getId());
        pst.setString(2, admin.getAccount());
        pst.setString(3, admin.getPassword());
        pst.setString(4, admin.getPhone());
        pst.setString(5, admin.getName());
        pst.setInt(6, admin.getId());
        return pst.executeUpdate();
    }


    public int insert(Connection conn,Admin admin) throws Exception{
        String sql = "select * from admin where id=?";
        PreparedStatement pst= conn.prepareStatement(sql);
        pst.setInt(1, admin.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) throw new BusinessException("管理员已存在");
        rs.close();
        pst.close();
        sql = "insert into admin(id,account,password,phone,name) "
                + " values(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, admin.getId());
        pst.setString(2, admin.getAccount());
        pst.setString(3, admin.getPassword());
        pst.setString(4, admin.getPhone());
        pst.setString(5, admin.getName());
        return pst.executeUpdate();
    }

    public int delete(Connection conn,Admin admin)throws Exception{
        String sql="select * from admin where id=?";
        PreparedStatement pst= conn.prepareStatement(sql);
        pst.setInt(1, admin.getId());
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) throw new BusinessException("管理员信息无法删除");
        rs.close();
        pst.close();
        sql="delete from admin where id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, admin.getId());
        return pst.executeUpdate();
    }
}
