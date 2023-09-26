package com.java.ui;

import com.java.dao.AdminDao;
import com.java.model.Admin;
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
import java.util.Vector;

public class AdminFrm extends JFrame {
    //public static int stuid;
    public static int num;

    private JPanel contentPane;
    private JTable stuxinxiTable;

    private DBUtil dbUtil=new DBUtil();
    private AdminDao adminDao=new AdminDao();
    private JTextField stuidText;
    private JTextField stunameText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminFrm frame = new AdminFrm();
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
    public AdminFrm() {
        setTitle("管理员管理");
        setBounds(100, 100, 608, 432);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("修改管理员密码");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xiugai(e);
            }
        });

        JButton btnNewButton_1 = new JButton("  ");
//        btnNewButton_1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                xinzeng(e);
//            }
//        });

        JButton btnNewButton_2 = new JButton("  ");
//        btnNewButton_2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                shanchu(e);
//            }
//        });

        JButton btnNewButton_3 = new JButton("刷新");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stuidText.setText("");
                stunameText.setText("");
                fillstuxinxiTable(new Admin());
            }
        });

        JLabel lblNewLabel = new JLabel("管理员编号:");

        stuidText = new JTextField();
        stuidText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("姓名:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        JButton btnNewButton_4 = new JButton("查询");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchActionPerformed(e);
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(lblNewLabel_1)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(47)
                                                .addComponent(btnNewButton_4)
                                                .addGap(29)
                                                .addComponent(btnNewButton_3))
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addComponent(btnNewButton)
                                                        .addGap(92)
                                                        .addComponent(btnNewButton_1)
                                                        .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_2))))
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(stuidText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(stunameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_4)
                                        .addComponent(btnNewButton_3))
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(btnNewButton_2)
                                        .addComponent(btnNewButton_1))
                                .addContainerGap())
        );

        stuxinxiTable = new JTable();
        stuxinxiTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "编号", "账号", "登录密码","联系电话","姓名"
                }
        ));
        scrollPane.setViewportView(stuxinxiTable);
        contentPane.setLayout(gl_contentPane);

        fillstuxinxiTable(new Admin());
    }


    private void searchActionPerformed(ActionEvent e) {
        String stuid=stuidText.getText();
        String stuname=stunameText.getText();
        Admin stu=new Admin();
        if(!StringUtil.isEmpty(stuid)) {
            stu.setId(Integer.parseInt(stuid));
        }
        if(!StringUtil.isEmpty(stuname)) {
            stu.setName(stuname);
        }
        fillstuxinxiTable(stu);

    }



    private void xiugai(ActionEvent e) {
        int row=stuxinxiTable.getSelectedRow();
        if(row==-1) {
            JOptionPane.showMessageDialog(null, "请选择需修改的管理员！");
            return;
        }
        num=(int)stuxinxiTable.getValueAt(row, 0);
//		stuid=(int)stuxinxiTable.getValueAt(row, 1);
        AdminUpdateFrm stuxiugaiFrm=new AdminUpdateFrm(num);
        stuxiugaiFrm.setVisible(true);
    }

    private void fillstuxinxiTable(Admin admin) {
        DefaultTableModel dtm=(DefaultTableModel)stuxinxiTable.getModel();
        dtm.setRowCount(0);
        Connection conn=null;

        try {
            conn=dbUtil.getConnection();
            ResultSet rs=adminDao.list(conn, admin);
            while(rs.next()) {
                Vector v=new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getString("account"));
                v.add(rs.getString("password"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("name"));
                dtm.addRow(v);
            }
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                dbUtil.closeCon(conn);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
