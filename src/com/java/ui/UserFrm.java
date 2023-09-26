package com.java.ui;

import com.java.dao.UserDao;
import com.java.model.Admin;
import com.java.model.User;
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

public class UserFrm extends JFrame {
    public static int kqid;

    private JPanel contentPane;
    private JTable stukaoqinTable;

    private DBUtil dbUtil = new DBUtil();
    private UserDao userDao = new UserDao();
    private JTextField stuidText;// 客户id
    private JTextField stunameText;//用户名
    private JTextField majorText;// 用户级别
    private JTextField classText;//用户注册时间
    private JTextField dateText;//客户累计消费总金额
    private JTextField signintimeText;//用户手机号
    private JTextField signouttimeText;//用户邮箱
    private JTextField styleText;//用户昵称

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserFrm frame = new UserFrm(null);
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
    public UserFrm(Admin admin) {
        setTitle("客户管理");
        setBounds(100, 100, 1200, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();

        JButton btnNewButton = new JButton("查询");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    searchActionPerformed(admin,e);
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                resetValueActionPerformed(new User(),arg0);
            }
        });

        JLabel lblNewLabel = new JLabel("客户ID:");

        stuidText = new JTextField();
        stuidText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("用户名:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("级别:");

        majorText = new JTextField();
        majorText.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("注册时间:");

        classText = new JTextField();
        classText.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("累计消费金额:");

        dateText = new JTextField();
        dateText.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("手机号:");

        signintimeText = new JTextField();
        signintimeText.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("邮箱:");

        signouttimeText = new JTextField();
        signouttimeText.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("昵称:");

        styleText = new JTextField();
        styleText.setColumns(10);

        JButton btnNewButton_2 = new JButton("  ");
//        btnNewButton_2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                AppAddFrm adminkaoqinxinzengFrm = new AppAddFrm();
//                adminkaoqinxinzengFrm.setVisible(true);
//            }
//        });

        JButton btnNewButton_3 = new JButton("删除");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "确认是否要删除", "确认", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    deleteActionPerformed(e);
                } else {
                    // 取消操作
                    System.out.println("取消操作");
                }

            }
        });

        JButton btnNewButton_4 = new JButton("重置用户密码");
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
                        "客户ID", "用户名", "级别", "注册时间", "累计消费总金额", "手机号", "邮箱", "昵称",
                }
        ));
        scrollPane.setViewportView(stukaoqinTable);
        contentPane.setLayout(gl_contentPane);
        this.fillkqcxjieguoTable(new User(),null,null);

    }

    private void deleteActionPerformed(ActionEvent e) {
        int row = stukaoqinTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择需删除的信息！");
            return;
        }
        int kqid = (int) stukaoqinTable.getValueAt(row, 0);
        User user = new User();
        user.setId(kqid);
        Connection conn = null;
        try {
            conn = dbUtil.getConnection();
            int n = userDao.delete(conn, user);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "删除成功");
            } else {
                JOptionPane.showMessageDialog(null, "删除失败");
            }
        } catch (Exception e1) {
//			JOptionPane.showMessageDialog(null, "此信息无法删除！");
//			return;
            e1.printStackTrace();
        }
        this.fillkqcxjieguoTable(new User(),null,null);
    }

    private void xiugai(ActionEvent e) {
        int row = stukaoqinTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "请选择重置的客户的信息！");
            return;
        }
        int kqid = (int) stukaoqinTable.getValueAt(row, 0);
        UserUpdateFrm adminkaoqinxiugaiFrm = new UserUpdateFrm(kqid);
        adminkaoqinxiugaiFrm.setVisible(true);

    }

    //开始查询
    private void searchActionPerformed(Admin admin,ActionEvent e) throws Exception {
        String stuid = stuidText.getText();// 客户id
        String stuname = stunameText.getText();//用户名
        String major = majorText.getText();// 用户级别
        String classes = classText.getText();//用户注册时间
        String date = dateText.getText();//客户累计消费总金额
        String signintime = signintimeText.getText();//用户手机号
        String signouttime = signouttimeText.getText();//用户邮箱
        String style = styleText.getText();//用户昵称
        User user = new User();

        if (!StringUtil.isEmpty(stuid)) {
            user.setId(Integer.parseInt(stuid));
        }
        if (!StringUtil.isEmpty(stuname)) {
            user.setAccount(stuname);
        }
        if (!StringUtil.isEmpty(major)) {
            user.setLevel(major);
        }
        if (!StringUtil.isEmpty(classes)) {
            user.setCreated(classes);
        }
        if (!StringUtil.isEmpty(date)) {
            user.setTotal(Integer.parseInt(date));
        }
        if (!StringUtil.isEmpty(signintime)) {
            user.setPhone(signintime);
        }
        if (!StringUtil.isEmpty(signouttime)) {
            user.setEmail(signouttime);
        }
        user.setName(style);
        this.fillkqcxjieguoTable(user,signintime,signouttime);
    }

    //重置查询
    private void resetValueActionPerformed(User user,ActionEvent arg0) {
        stuidText.setText("");
        stunameText.setText("");
        majorText.setText("");
        classText.setText("");
        dateText.setText("");
        signintimeText.setText("");
        signouttimeText.setText("");
        styleText.setText("");
        this.fillkqcxjieguoTable(user,null,null);
    }

    /**
     * 用户列表
     *
     * @param user
     */
    private void fillkqcxjieguoTable(User user,String signintime,String signouttime) {
        DefaultTableModel dtm = (DefaultTableModel) stukaoqinTable.getModel();
        dtm.setRowCount(0);
        Connection conn = null;

        try {
            conn = dbUtil.getConnection();
            ResultSet rs = userDao.list(conn, user);
            while (rs.next()) {
                Vector v = new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getString("account"));
                int level = rs.getInt("level");
                String levelString = "";
                if (level == 1){
                    levelString = "铜牌客户";
                }else if (level == 2){
                    levelString = "银牌客户";
                }else if (level == 3){
                    levelString = "金牌客户";
                }
                v.add(levelString);
                v.add(rs.getString("created"));
                v.add(rs.getInt("total"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("email"));
                v.add(rs.getString("name"));
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
