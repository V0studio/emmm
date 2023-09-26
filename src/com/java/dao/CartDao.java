package com.java.dao;


import com.java.model.Cart;
import com.java.model.Good;
import com.java.util.BusinessException;
import com.java.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDao {


    public ResultSet list(Connection conn, Cart cart) throws Exception {
        StringBuffer sb = new StringBuffer("select * from cart");
        if (cart.getId() != 0) {
            sb.append(" and id='" + cart.getId() + "' ");
        }
        if (cart.getGoodNumber() != 0) {
            sb.append(" and good_number ='" + cart.getGoodNumber() + "' ");
        }
        if (!StringUtil.isEmpty(cart.getUserName())) {
            sb.append(" and user_name like '%" + cart.getUserName() + "%' ");
        }
        if (cart.getUserId() != 0) {
            sb.append(" and user_id ='" + cart.getUserId() + "' ");
        }
        if (!StringUtil.isEmpty(cart.getCreated())) {
            sb.append(" and created like '%" + cart.getCreated() + "%' ");
        }
        if (cart.getTotalPrice() != 0) {
            sb.append(" and total_price ='" + cart.getTotalPrice() + "' ");
        }
        if (cart.getPrice() != 0) {
            sb.append(" and price ='" + cart.getPrice() + "' ");
        }
        if (cart.getGoodQuantity() != 0) {
            sb.append(" and good_quantity ='" + cart.getGoodQuantity() + "' ");
        }
        PreparedStatement pst = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
        ResultSet rs = pst.executeQuery();
        return rs;
    }


    public int updatebynum(Connection conn, Cart cart) throws Exception {
        String sql = "update cart set id=?,good_number=?,user_name=?,user_id=?,created=?,total_price=?,price=?,good_quantity=? where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, cart.getId());
        pst.setInt(2, cart.getGoodNumber());
        pst.setString(3, cart.getUserName());
        pst.setInt(4, cart.getUserId());
        pst.setString(5, cart.getCreated());
        pst.setInt(6, cart.getTotalPrice());
        pst.setInt(7, cart.getPrice());
        pst.setInt(8, cart.getGoodQuantity());
        pst.setInt(9, cart.getId());
        return pst.executeUpdate();
    }

    public int insert(Connection conn, Cart cart) throws Exception {
        String sql = "insert into cart(good_number,user_name,user_id,created,total_price,price,good_quantity ) "
                + " values(?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, cart.getGoodNumber());
        pst.setString(2, cart.getUserName());
        pst.setInt(3, cart.getUserId());
        pst.setString(4, cart.getCreated());
        pst.setInt(5, cart.getTotalPrice());
        pst.setInt(6, cart.getPrice());
        pst.setInt(7, cart.getGoodQuantity());
        return pst.executeUpdate();
    }

    public int delete(Connection conn,Cart cart) throws Exception {
        String sql = "select * from cart where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, cart.getId());
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) throw new BusinessException("购物车无法删除");
        rs.close();
        pst.close();
        sql = "delete from cart where id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, cart.getId());
        return pst.executeUpdate();
    }

    public Cart findById(Connection conn,int id) throws Exception {
        String sql = "select * from cart where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        Cart cart = new Cart();
        if (rs.next()){
            cart.setId(rs.getInt("id"));
            cart.setGoodNumber(rs.getInt("good_number"));
            cart.setUserName(rs.getString("user_name"));
            cart.setUserId(rs.getInt("user_id"));
            cart.setCreated(rs.getString("created"));
            cart.setTotalPrice(rs.getInt("total_price"));
            cart.setPrice(rs.getInt("price"));
            cart.setGoodQuantity(rs.getInt("good_quantity"));
        }
        return cart;
    }
}
