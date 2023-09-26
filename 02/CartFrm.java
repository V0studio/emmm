package com.java.ui;

import com.java.dao.CartDao;
import com.java.dao.GoodDao;
import com.java.dao.OrderDao;
import com.java.model.*;
import com.java.util.DBUtil;
import com.java.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class CartFrm extends JFrame {
    public static int kqid;

    private JPanel contentPane;
    private JTable stukaoqinTable;

    private DBUtil dbUtil = new DBUtil();
    private GoodDao goodDao = new GoodDao();
    private CartDao cartDao = new CartDao();
    private OrderDao orderDao = new OrderDao();
    private JTextField stuidText;// 购物车编号
    private JTextField stunameText;//商品编号
    private JTextField majorText;// 用户名
    private JTextField classText;//用户编号
    private JTextField dateText;//加入日期
    private JTextField signintimeText;//总价
    private JTextField signouttimeText;//单价
    private JTextField styleText;//数量

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CartFrm frame = new CartFrm(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CartFrm(User user) {
        setTitle("购物车列表");
        setBounds(100, 100, 1200, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    searchActionPerformed(user,e);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        JButton btnNewButton_1 = new JButton("付款");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    payActionPerformed(user,arg0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblNewLabel = new JLabel("购物车编号:");

        stuidText = new JTextField();
        stuidText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("商品编号:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("用户名:");

        majorText = new JTextField();
        majorText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("用户编号:");

        classText = new JTextField();
        classText.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("加入日期:");

        dateText = new JTextField();
        dateText.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("总价:");

        signintimeText = new JTextField();
        signintimeText.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("单价:");

        signouttimeText = new JTextField();
        signouttimeText.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("数量:");

        styleText = new JTextField();
        styleText.setColumns(10);

        JButton btnNewButton_2 = new JButton("  ");
//        btnNewButton_2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                CartAddFrm cartAddFrm = new CartAddFrm(user);
//                cartAddFrm.setVisible(true);
//            }
//        });

        JButton btnNewButton_3 = new JButton("删除");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "确认是否要删除", "确认", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    deleteActionPerformed(user,e);
                } else {
                    // 取消操作
                    System.out.println("取消操作");
                }

            }
        });

        JButton btnNewButton_4 = new JButton("修改购物车");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xiugai(e);
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_4)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(dateText))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_1)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_2))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_5)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(signintimeText)))
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(majorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_3)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(classText, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(lblNewLabel_6)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(signouttimeText, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(lblNewLabel_7)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(styleText, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                                                .addComponent(btnNewButton_2)
                                                .addGap(18)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(btnNewButton_1)))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                .addComponent(btnNewButton_4)
                                                .addGap(18)
                                                .addComponent(btnNewButton_3)))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(64)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_4)
                                                        .addComponent(dateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_5)
                                                        .addComponent(signintimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_6)
                                                        .addComponent(signouttimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_7)
                                                        .addComponent(styleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(btnNewButton_2)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(19)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_1)
                                                        .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_2)
                                                        .addComponent(majorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel_3)
                                                        .addComponent(classText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnNewButton_1))))
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton_3)
                                        .addComponent(btnNewButton_4))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        stukaoqinTable = new JTable();
        stukaoqinTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "购物车编号", "商品编号", "用户名", "用户编号", "加入日期", "总价", "价格", "数量",
                }
        ));
        scrollPane.setViewportView(stukaoqinTable);
        contentPane.setLayout(gl_contentPane);
        Cart cart = new Cart();
        cart.setUserId(user.getId());
        this.fillkqcxjieguoTable(cart,null,null);

    }

    private void payActionPerformed(User user,ActionEvent e) throws Exception {
        int row = stukaoqinTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择需要付款的信息！");
            return;
        }
        int kqid = (int) stukaoqinTable.getValueAt(row, 0);
        Cart cart = new Cart();
        cart.setId(kqid);
        Connection conn = null;
        try {
            conn = dbUtil.getConnection();
            Cart newCart = cartDao.findById(conn,kqid);
            Good good = goodDao.findById(conn,newCart.getGoodNumber());
            good.setQuantity(good.getQuantity()-newCart.getGoodQuantity());
            goodDao.updatebynum(conn,good);
            Order order = new Order();
            order.setGoodNumber(newCart.getGoodNumber());
            order.setGoodQuantity(newCart.getGoodQuantity());
            order.setUserName(newCart.getUserName());
            order.setUserId(newCart.getUserId());
            order.setPrice(newCart.getPrice());
            order.setTotalPrice(newCart.getTotalPrice());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(new Date());
            order.setCreated(format);
            orderDao.insert(conn,order);
            int n = cartDao.delete(conn, cart);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "付款成功");
            } else {
                JOptionPane.showMessageDialog(null, "付款失败");
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "无法付款！");
            return;
        }
        Cart cart1 = new Cart();
        cart1.setUserId(user.getId());
        this.fillkqcxjieguoTable(cart1,null,null);
    }


    private void deleteActionPerformed(User user,ActionEvent e) {
        int row = stukaoqinTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择需删除的信息！");
            return;
        }
        int kqid = (int) stukaoqinTable.getValueAt(row, 0);
        Cart cart = new Cart();
        cart.setId(kqid);
        Connection conn = null;
        try {
            conn = dbUtil.getConnection();
            int n = cartDao.delete(conn, cart);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "删除成功");
            } else {
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        } catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "此信息无法删除！");
			return;
        }
        Cart cart1 = new Cart();
        cart1.setUserId(user.getId());
        this.fillkqcxjieguoTable(cart1,null,null);
    }

    private void xiugai(ActionEvent e) {
        int row = stukaoqinTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择需修改的信息！");
            return;
        }
        int kqid = (int) stukaoqinTable.getValueAt(row, 0);
        CartUpdateFrm cartUpdateFrm = new CartUpdateFrm(kqid);
        cartUpdateFrm.setVisible(true);

    }

    //开始查询
    private void searchActionPerformed(User user,ActionEvent e) throws Exception {
        String stuid = stuidText.getText();// 购物车编号
        String stuname = stunameText.getText();//商品编号
        String major = majorText.getText();// 用户名
        String classes = classText.getText();//用户id
        String date = dateText.getText();//加入日期
        String signintime = signintimeText.getText();//总价
        String signouttime = signouttimeText.getText();//单价
        String style = styleText.getText();//数量
        Cart cart = new Cart();

        if (!StringUtil.isEmpty(stuid)) {
            cart.setId(Integer.parseInt(stuid));
        }
        if (!StringUtil.isEmpty(stuname)) {
            cart.setGoodNumber(Integer.parseInt(stuname));
        }
        cart.setUserName(user.getName());
        cart.setUserId(user.getId());
        if (!StringUtil.isEmpty(date)) {
            cart.setCreated(date);
        }
        if (!StringUtil.isEmpty(signintime)) {
            cart.setTotalPrice(Integer.parseInt(signintime));
        }
        if (!StringUtil.isEmpty(signouttime)) {
            cart.setPrice(Integer.parseInt(signouttime));
        }
        if (!StringUtil.isEmpty(style)){
            cart.setGoodQuantity(Integer.parseInt(style));
        }
        this.fillkqcxjieguoTable(cart,signintime,signouttime);
    }

    /**
     * 购物车列表
     *
     * @param cart
     */
    private void fillkqcxjieguoTable(Cart cart,String signintime,String signouttime) {
        DefaultTableModel dtm = (DefaultTableModel) stukaoqinTable.getModel();
        dtm.setRowCount(0);
        Connection conn = null;

        try {
            conn = dbUtil.getConnection();
            ResultSet rs = cartDao.list(conn, cart);
            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getInt("good_number"));
                v.add(rs.getString("user_name"));
                v.add(rs.getInt("user_id"));
                v.add(rs.getString("created"));
                v.add(rs.getInt("total_price"));
                v.add(rs.getInt("price"));
                v.add(rs.getInt("good_quantity"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(conn);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
