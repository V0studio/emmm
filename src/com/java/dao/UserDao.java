package com.java.dao;


import com.java.model.User;
import com.java.util.BusinessException;
import com.java.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    public User login(Connection conn, User user) throws Exception {
        User resultStu = null;
        String sql = "select * from user where account=? and password=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, user.getAccount());
        pst.setString(2, user.getPassword());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            resultStu = new User();
            resultStu.setId(rs.getInt("id"));
            resultStu.setAccount(rs.getString("account"));
            resultStu.setPassword(rs.getString("password"));
            resultStu.setName(rs.getString("name"));
            resultStu.setPhone(rs.getString("phone"));
            resultStu.setEmail(rs.getString("email"));
        }
        return resultStu;
    }

    public ResultSet list(Connection conn, User user) throws Exception {
        StringBuffer sb = new StringBuffer("select * from user");
        if (user.getId() != 0) {
            sb.append(" and id='" + user.getId() + "' ");
        }
        if (!StringUtil.isEmpty(user.getAccount())) {
            sb.append(" and account like '%" + user.getAccount() + "%' ");
        }
        if (!StringUtil.isEmpty(user.getPassword())) {
            sb.append(" and password like '%" + user.getPassword() + "%' ");
        }
        if (!StringUtil.isEmpty(user.getName())) {
            sb.append(" and name like '%" + user.getName() + "%' ");
        }
        if (!StringUtil.isEmpty(user.getLevel())) {
            sb.append(" and level like '%" + user.getLevel() + "%' ");
        }
        if (!StringUtil.isEmpty(user.getCreated())) {
            sb.append(" and created like '%" + user.getCreated() + "%' ");
        }
        if (user.getTotal()!=0) {
            sb.append(" and total like '%" + user.getTotal() + "%' ");
        }
        if (!StringUtil.isEmpty(user.getPhone())) {
            sb.append(" and phone like '%" + user.getPhone() + "%' ");
        }
        if (!StringUtil.isEmpty(user.getEmail())) {
            sb.append(" and email like '%" + user.getEmail() + "%' ");
        }
        PreparedStatement pst = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
        ResultSet rs = pst.executeQuery();
        return rs;
    }


    public int updatebynum(Connection conn, User user) throws Exception {
        String sql = "update user set account=?,password=?,name=?,level=?,created=?,total=?,phone=?,email=? where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, user.getAccount());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getName());
        pst.setString(4, user.getLevel());
        pst.setString(5, user.getCreated());
        pst.setInt(6, user.getTotal());
        pst.setString(7, user.getPhone());
        pst.setString(8, user.getEmail());
        pst.setInt(9, user.getId());
        return pst.executeUpdate();
    }

    public int insert(Connection conn, User user) throws Exception {
        String sql = "select * from user where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, user.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) throw new BusinessException("用户已存在");
        rs.close();
        pst.close();
        sql = "insert into user(id,account,password,name,level,created,total,phone,email) "
                + " values(?,?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, user.getId());
        pst.setString(2, user.getAccount());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getName());
        pst.setString(5, user.getLevel());
        pst.setString(6, user.getCreated());
        pst.setInt(7, user.getTotal());
        pst.setString(8, user.getPhone());
        pst.setString(9, user.getEmail());
        return pst.executeUpdate();
    }

    public int register(Connection conn, User user) throws Exception {
        String sql = "select * from user where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, user.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) throw new BusinessException("用户已存在");
        rs.close();
        pst.close();
        sql = "insert into user(account,password) "
                + " values(?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, user.getAccount());
        pst.setString(2, user.getPassword());
        return pst.executeUpdate();
    }

    public int delete(Connection conn, User user) throws Exception {
        String sql = "select * from user where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, user.getId());
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) throw new BusinessException("用户无法删除");
        rs.close();
        pst.close();
        sql = "delete from user where id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1,user.getId());
        return pst.executeUpdate();
    }
}
