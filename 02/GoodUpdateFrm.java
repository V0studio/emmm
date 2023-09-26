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

public class GoodUpdateFrm extends JFrame {
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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GoodUpdateFrm frame = new GoodUpdateFrm(num);
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
    public GoodUpdateFrm(int num) {
        this.num = num;
        setTitle("商品修改");
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);


        JLabel lblNewLabel_1 = new JLabel("商品编号:");

        stuidText = new JTextField();
        stuidText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("商品名称:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("生产厂家:");
        majorText = new JTextField();
        majorText.setEditable(false);
        majorText.setColumns(10);


        JLabel lblNewLabel_4 = new JLabel("生产日期:");
        classText = new JTextField();
        classText.setEditable(false);
        classText.setColumns(10);

        lblNewLabel_5 = new JLabel("型号:");

        dateText = new JTextField();
        dateText.setColumns(10);

        lblNewLabel_6 = new JLabel("进货价:");

        styleText = new JTextField();
        styleText.setColumns(10);

        lblNewLabel_7 = new JLabel("零售价格:");

        signintimeText = new JTextField();
        signintimeText.setColumns(10);

        lblNewLabel_8 = new JLabel("数量:");

        signouttimeText = new JTextField();
        signouttimeText.setColumns(10);

        btnNewButton = new JButton("确定");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    updateActionPerformed(e);
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

    private void updateActionPerformed(ActionEvent e) throws Exception {
        String stuid = stuidText.getText();
        String stuname = stunameText.getText();
        String major = majorText.getText();
        String classes = classText.getText();
        String date = dateText.getText();
        String style = styleText.getText();
        String signintime = signintimeText.getText();
        String signouttime = signouttimeText.getText();

        if (!StringUtil.isEmpty(stuname) && !StringUtil.isEmpty(stuid) && !StringUtil.isEmpty(date) && !StringUtil.isEmpty(signintime)
                && !StringUtil.isEmpty(signouttime) && !StringUtil.isEmpty(style)) {
        } else {
            JOptionPane.showMessageDialog(null, "请确保信息完整！");
            return;
        }
        Good good = new Good();
        if (!StringUtil.isEmpty(stuid)) {
            good.setId(Integer.parseInt(stuid));
        }
        if (!StringUtil.isEmpty(stuname)) {
            good.setName(stuname);
        }
        if (!StringUtil.isEmpty(major)) {
            good.setCreated(major);
        }
        if (!StringUtil.isEmpty(classes)) {
            good.setMade(classes);
        }
        if (!StringUtil.isEmpty(date)) {
            good.setModel(date);
        }
        if (!StringUtil.isEmpty(style)){
            good.setPurchasePrice(Integer.parseInt(style));
        }
        if (!StringUtil.isEmpty(signintime)) {
            good.setRetailPrice(Integer.parseInt(signintime));
        }
        if (!StringUtil.isEmpty(signouttime)) {
            good.setQuantity(Integer.parseInt(signouttime));
        }

        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            int n = goodDao.updatebynum(conn, good);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "修改成功");
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "需修改信息已存在！");
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
                stunameText.setText(rs.getString("name"));
                majorText.setText(rs.getString("created"));
                classText.setText(rs.getString("made"));
                dateText.setText(rs.getString("model"));
                styleText.setText(String.valueOf(rs.getInt("purchase_price")));
                signintimeText.setText(String.valueOf(rs.getInt("retail_price")));
                signouttimeText.setText(String.valueOf(rs.getInt("quantity")));

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
