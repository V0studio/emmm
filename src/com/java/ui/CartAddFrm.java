package com.java.ui;

import com.java.dao.CartDao;
import com.java.dao.GoodDao;
import com.java.model.Cart;
import com.java.model.Good;
import com.java.model.User;
import com.java.util.DBUtil;
import com.java.util.StringUtil;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CartAddFrm extends JFrame {
    public static int num;
    private JPanel contentPane;
    private JTextField stuidText;
    private JTextField stunameText;
    private JTextField majorText;
    private JTextField classText;
    private JLabel lblNewLabel_5;
    private JTextField dateText;
    private JLabel lblNewLabel_6;
    private JTextField styleText;
    private JLabel lblNewLabel_7;
    private JTextField signintimeText;
    private JLabel lblNewLabel_8;
    private JTextField signouttimeText;
    private JButton btnNewButton;

    private DBUtil dbUtil = new DBUtil();
    private GoodDao goodDao = new GoodDao();
    private CartDao cartDao = new CartDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CartAddFrm frame = new CartAddFrm(num,null);
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
    public CartAddFrm(int num, User user) {
        this.num = num;
        setTitle("加入购物车");
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);


        JLabel lblNewLabel_1 = new JLabel("商品编号:");

        stuidText = new JTextField();
        stuidText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("商品数量:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("  ");
        majorText = new JTextField();
        majorText.setEditable(false);
        majorText.setColumns(10);


        JLabel lblNewLabel_4 = new JLabel("  ");
        classText = new JTextField();
        classText.setEditable(false);
        classText.setColumns(10);

        lblNewLabel_5 = new JLabel("  ");

        dateText = new JTextField();
        dateText.setColumns(10);

        lblNewLabel_6 = new JLabel("  ");

        styleText = new JTextField();
        styleText.setColumns(10);

        lblNewLabel_7 = new JLabel("  ");

        signintimeText = new JTextField();
        signintimeText.setColumns(10);

        lblNewLabel_8 = new JLabel("  :");

        signouttimeText = new JTextField();
        signouttimeText.setColumns(10);

        btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateActionPerformed(e,user);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(55)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblNewLabel_7)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(signintimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(lblNewLabel_8)
                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                .addComponent(signouttimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_4)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(majorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_5)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(dateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(43)
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(classText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_6)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(styleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(184)
                                                .addComponent(btnNewButton)))
                                .addContainerGap(129, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3)
                                        .addComponent(lblNewLabel_4)
                                        .addComponent(majorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(classText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_5)
                                        .addComponent(dateText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_6)
                                        .addComponent(styleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_7)
                                        .addComponent(signintimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_8)
                                        .addComponent(signouttimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(btnNewButton)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        fillPane();
    }

    private void updateActionPerformed(ActionEvent e,User user) throws Exception {
        String stuid = stuidText.getText();
        String stuname = stunameText.getText();
        if (!StringUtil.isEmpty(stuname) && !StringUtil.isEmpty(stuid)) {
        } else {
            JOptionPane.showMessageDialog(null, "请确保信息完整！");
            return;
        }

        try {
            Connection conn = null;
            conn = DBUtil.getConnection();

            Cart cart = new Cart();
            if (!StringUtil.isEmpty(stuid)) {
                cart.setGoodNumber(Integer.parseInt(stuid));
            }
            if (!StringUtil.isEmpty(stuname)) {
                cart.setGoodQuantity(Integer.parseInt(stuname));
            }
            cart.setUserId(user.getId());
            cart.setUserName(user.getName());
            Good byId = goodDao.findById(conn, Integer.parseInt(stuid));
            if (byId.getQuantity()<=0){
                JOptionPane.showMessageDialog(null, "商品数量为空,无法加入购物车");
                return;
            }
            cart.setPrice(byId.getRetailPrice());
            cart.setTotalPrice(byId.getRetailPrice()*Integer.parseInt(stuname));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(new Date());
            cart.setCreated(format);
            int n = cartDao.insert(conn, cart);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "加入购物车成功");
            } else {
                JOptionPane.showMessageDialog(null, "加入购物车失败");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "购物车已存在！");
            return;
        }
        fillPane();

    }

    private void fillPane() {
        Good good = new Good();
        good.setId(num);
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            ResultSet rs = goodDao.list(conn, good);
            if (rs.next()) {
                stuidText.setText(String.valueOf(rs.getInt("id")));
                stunameText.setText(0+"");
                majorText.setText(rs.getString(" "));
                classText.setText(rs.getString(" "));
                dateText.setText(rs.getString(" "));
                signintimeText.setText(String.valueOf(rs.getInt(" ")));
                signouttimeText.setText(String.valueOf(rs.getInt(" ")));
                styleText.setText(String.valueOf(rs.getInt(" ")));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
