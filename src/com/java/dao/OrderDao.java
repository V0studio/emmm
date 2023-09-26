package com.java.dao;



import com.java.model.Order;
import com.java.util.BusinessException;
import com.java.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class OrderDao {


    public ResultSet list(Connection conn, Order order) throws Exception {
        StringBuffer sb = new StringBuffer("select * from orders");
        if (order.getId() != 0) {
            sb.append(" and id='" + order.getId() + "' ");
        }
        if (order.getGoodNumber() != 0) {
            sb.append(" and good_number ='" + order.getGoodNumber() + "' ");
        }
        if (!StringUtil.isEmpty(order.getUserName())) {
            sb.append(" and user_name like '%" + order.getUserName() + "%' ");
        }
        if (order.getUserId() != 0) {
            sb.append(" and user_id ='" + order.getUserId() + "' ");
        }
        if (!StringUtil.isEmpty(order.getCreated())) {
            sb.append(" and created like '%" + order.getCreated() + "%' ");
        }
        if (order.getTotalPrice() != 0) {
            sb.append(" and total_price ='" + order.getTotalPrice() + "' ");
        }
        if (order.getPrice() != 0) {
            sb.append(" and price ='" + order.getPrice() + "' ");
        }
        if (order.getGoodQuantity() != 0) {
            sb.append(" and good_quantity ='" + order.getGoodQuantity() + "' ");
        }
        PreparedStatement pst = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
        ResultSet rs = pst.executeQuery();
        return rs;
    }


    public int updatebynum(Connection conn, Order order) throws Exception {
        String sql = "update orders set id=?,good_number=?,user_name=?,user_id=?,created=?,total_price=?,price=?,good_quantity=? where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, order.getId());
        pst.setInt(2, order.getGoodNumber());
        pst.setString(3, order.getUserName());
        pst.setInt(4, order.getUserId());
        pst.setString(5, order.getCreated());
        pst.setInt(6, order.getTotalPrice());
        pst.setInt(7, order.getPrice());
        pst.setInt(8, order.getGoodQuantity());
        pst.setInt(9, order.getId());
        return pst.executeUpdate();
    }

    public int insert(Connection conn, Order order) throws Exception {
        String sql = "insert into orders(good_number,user_name,user_id,created,total_price,price,good_quantity ) "
                + " values(?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, order.getGoodNumber());
        pst.setString(2, order.getUserName());
        pst.setInt(3, order.getUserId());
        pst.setString(4, order.getCreated());
        pst.setInt(5, order.getTotalPrice());
        pst.setInt(6, order.getPrice());
        pst.setInt(7, order.getGoodQuantity());
        return pst.executeUpdate();
    }

    public int delete(Connection conn,Order order) throws Exception {
        String sql = "select * from orders where id=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, order.getId());
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) throw new BusinessException("订单无法删除");
        rs.close();
        pst.close();
        sql = "delete from orders where id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, order.getId());
        return pst.executeUpdate();
    }
}
