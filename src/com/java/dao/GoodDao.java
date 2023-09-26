package com.java.dao;


import com.java.model.Cart;
import com.java.model.Good;
import com.java.util.BusinessException;
import com.java.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodDao {


    public ResultSet list(Connection conn, Good good) throws Exception {
        StringBuffer sb = new StringBuffer("select * from good");
        if (good.getId() != 0) {
            sb.append(" and id ='" + good.getId() + "' ");
        }
        if (!StringUtil.isEmpty(good.getName())) {
            sb.append(" and name like '%" + good.getName() + "%' ");
        }
        if (!StringUtil.isEmpty(good.getMade())) {
            sb.append(" and made like '%" + good.getMade() + "%' ");
        }
        if (!StringUtil.isEmpty(good.getCreated())) {
            sb.append(" and created like '%" + good.getCreated() + "%' ");
        }
        if (!StringUtil.isEmpty(good.getModel())) {
            sb.append(" and model like '%" + good.getModel() + "%' ");
        }
        if (good.getPurchasePrice()!=0) {
            sb.append(" and purchase_price like '%" + good.getPurchasePrice() + "%' ");
        }
        if (good.getRetailPrice() != 0 ) {
            sb.append(" and retail_price like '%" + good.getRetailPrice() + "%' ");
        }
        if (good.getQuantity() != 0 ) {
            sb.append(" and quantity like '%" + good.getQuantity() + "%' ");
        }
        PreparedStatement pst = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
        ResultSet rs = pst.executeQuery();
        return rs;
    }


    public int updatebynum(Connection conn, Good good) throws Exception {
        String sql = "update good set id=?,name=?,made=?,created=?,model=?,purchase_price=?,retail_price=?,quantity=? where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, good.getId());
        pst.setString(2, good.getName());
        pst.setString(3, good.getMade());
        pst.setString(4, good.getCreated());
        pst.setString(5, good.getMade());
        pst.setInt(6, good.getPurchasePrice());
        pst.setInt(7, good.getRetailPrice());
        pst.setInt(8, good.getQuantity());
        pst.setInt(9, good.getId());
        return pst.executeUpdate();
    }

    public int insert(Connection conn, Good good) throws Exception {
        String sql = "select * from good where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, good.getId());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) throw new BusinessException("商品已存在");
        rs.close();
        pst.close();
        sql = "insert into good(id,name,made,created,model,purchase_price,retail_price,quantity) "
                + " values(?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, good.getId());
        pst.setString(2, good.getName());
        pst.setString(3, good.getMade());
        pst.setString(4, good.getCreated());
        pst.setString(5, good.getMade());
        pst.setInt(6, good.getPurchasePrice());
        pst.setInt(7, good.getRetailPrice());
        pst.setInt(8, good.getQuantity());
        return pst.executeUpdate();
    }

    public int delete(Connection conn, Good good) throws Exception {
        String sql = "select * from good where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, good.getId());
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) throw new BusinessException("商品无法删除");
        rs.close();
        pst.close();
        sql = "delete from good where id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, good.getId());
        return pst.executeUpdate();
    }

    public Good findById(Connection conn, int goodNumber) throws SQLException {
        String sql = "select * from good where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1,goodNumber);
        ResultSet rs = pst.executeQuery();
        Good good = new Good();
        if (rs.next()){
            good.setId(rs.getInt("id"));
            good.setName(rs.getString("name"));
            good.setMade(rs.getString("made"));
            good.setCreated(rs.getString("created"));
            good.setModel(rs.getString("model"));
            good.setPurchasePrice(rs.getInt("purchase_price"));
            good.setRetailPrice(rs.getInt("retail_price"));
            good.setQuantity(rs.getInt("quantity"));
        }
        return good;
    }
}
