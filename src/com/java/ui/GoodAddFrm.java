package com.java.ui;


import com.java.dao.GoodDao;


import com.java.model.Good;
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

public class GoodAddFrm extends JFrame {

    public static int adminNo;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField stuidText;
    private JLabel lblNewLabel_2;
    private JTextField stunameText;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JTextField majorText;
    private JLabel lblNewLabel_5;
    private JTextField classText;
    private JLabel lblNewLabel_6;
    private JTextField entryyearText;
    private JLabel lblNewLabel_7;
    private JTextField phonenumText;
    private JLabel lblNewLabel_8;
    private JTextField emailText;
    private JLabel lblNewLabel_9;
    private JTextField passwordText;
    private JButton btnNewButton;

    private DBUtil dbUtil = new DBUtil();
    private GoodDao goodDao = new GoodDao();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GoodAddFrm frame = new GoodAddFrm();
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
    public GoodAddFrm() {
        setTitle("添加商品");
        setBounds(100, 100, 473, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        lblNewLabel = new JLabel("商品编号:");

        stuidText = new JTextField();
        stuidText.setColumns(10);


        lblNewLabel_2 = new JLabel("商品名称:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        lblNewLabel_3 = new JLabel("");

        lblNewLabel_4 = new JLabel("生产厂家:");

        majorText = new JTextField();
        majorText.setColumns(10);

        lblNewLabel_5 = new JLabel("生产日期:");

        classText = new JTextField();
        classText.setColumns(10);

        lblNewLabel_6 = new JLabel("型号:");

        entryyearText = new JTextField();
        entryyearText.setColumns(10);

        lblNewLabel_7 = new JLabel("进货价:");

        phonenumText = new JTextField();
        phonenumText.setColumns(10);

        lblNewLabel_8 = new JLabel("零售价格:");

        emailText = new JTextField();
        emailText.setColumns(10);

        lblNewLabel_9 = new JLabel("数量:");

        passwordText = new JTextField();
        passwordText.setColumns(10);

        btnNewButton = new JButton("确认添加");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateActionPerformed(e);
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNewLabel_4)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(majorText, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNewLabel_8)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(emailText, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNewLabel_6)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(entryyearText, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                        .addComponent(lblNewLabel)
                                                                        .addComponent(lblNewLabel_3))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addGap(34)
                                                                        .addComponent(stuidText, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                                                        .addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNewLabel_2)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNewLabel_5)
                                                                        .addPreferredGap(ComponentPlacement.RELATED)
                                                                        .addComponent(classText))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_7)
                                                                                .addComponent(lblNewLabel_9))
                                                                        .addGap(4)
                                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                                                .addComponent(phonenumText))))
                                                        .addGap(76))
                                                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                        .addComponent(btnNewButton)
                                                        .addGap(193)))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_2)
                                                        .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(29)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_5)
                                                        .addComponent(classText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(32)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_7)
                                                        .addComponent(phonenumText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(29)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_9)
                                                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblNewLabel))
                                                .addGap(29)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_3)
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(lblNewLabel_4)
                                                                .addComponent(majorText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(32)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_6)
                                                        .addComponent(entryyearText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(29)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(lblNewLabel_8)
                                                        .addComponent(emailText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(btnNewButton)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);

    }

    private void updateActionPerformed(ActionEvent e) {
        String AppNo = stuidText.getText();
        String ActNo = stunameText.getText();
        String ActName = majorText.getText();
        String AppTime = classText.getText();
        String AppState = entryyearText.getText();
        String PeoNo = phonenumText.getText();
        String PeoName = emailText.getText();
        String PeoPhone = passwordText.getText();


        if (StringUtil.isEmpty(AppNo)) {
            JOptionPane.showMessageDialog(null, "商品编号不能为空");
            return;
        }
        if (StringUtil.isEmpty(ActNo)) {
            JOptionPane.showMessageDialog(null, "商品名称不能为空");
            return;
        }
        if (StringUtil.isEmpty(ActName)) {
            JOptionPane.showMessageDialog(null, "生产厂家不能为空");
            return;
        }
        if (StringUtil.isEmpty(AppTime)) {
            JOptionPane.showMessageDialog(null, "生产日期不能为空");
            return;
        }
        if (StringUtil.isEmpty(AppState)) {
            JOptionPane.showMessageDialog(null, "型号不能为空");
            return;
        }
        if (StringUtil.isEmpty(PeoNo)) {
            JOptionPane.showMessageDialog(null, "进货价不能为空");
            return;
        }
        if (StringUtil.isEmpty(PeoName)) {
            JOptionPane.showMessageDialog(null, "零售价格不能为空");
            return;
        }
        if (StringUtil.isEmpty(PeoPhone)) {
            JOptionPane.showMessageDialog(null, "数量不能为空");
            return;
        }
        Good good = new Good();
        good.setId(Integer.parseInt(AppNo));
        good.setName(ActNo);
        good.setMade(ActName);
        good.setCreated(AppTime);
        good.setModel(AppState);
        good.setPurchasePrice(Integer.parseInt(PeoNo));
        good.setRetailPrice(Integer.parseInt(PeoName));
        good.setQuantity(Integer.parseInt(PeoPhone));
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            int n = goodDao.insert(conn, good);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "添加商品成功");
            } else {
                JOptionPane.showMessageDialog(null, "添加商品失败");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "商品编号不能重复！");
            return;
        }

    }



}
