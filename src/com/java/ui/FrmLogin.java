package com.java.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.AdminDao;
import com.java.dao.UserDao;
import com.java.model.Admin;
import com.java.model.User;
import com.java.util.DBUtil;
import com.java.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmLogin extends JFrame {

    public static int userid;

    private JPanel contentPane;
    private JTextField textField_name;
    private JTextField textField_password;
    private JComboBox userTpye;
    private UserDao userDao = new UserDao();
    private AdminDao adminDao = new AdminDao();
    private DBUtil dbUtil = new DBUtil();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmLogin frame = new FrmLogin();
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
    public FrmLogin() {
        setTitle("超市管理系统首页");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 621, 393);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("账号:");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));

        textField_name = new JTextField();
        textField_name.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("密码:");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));

        textField_password = new JTextField();
        textField_password.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("超市管理系统");
        lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 26));

        JButton btnNewButton = new JButton("登录");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    loginActionPerformed(arg0);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        JButton zhuNewButton = new JButton("用户注册");
        zhuNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        zhuNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    registerActionPerformed(arg0);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        userTpye = new JComboBox();
        userTpye.setFont(new Font("宋体", Font.PLAIN, 18));
        userTpye.setModel(new DefaultComboBoxModel(new String[]{"用户", "管理员"}));

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(156)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(textField_password, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel_2)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18)
                                                                .addComponent(userTpye, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(104, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(268, Short.MAX_VALUE)
                                .addComponent(btnNewButton)
                                .addGap(260))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(268, Short.MAX_VALUE)
                                .addComponent(zhuNewButton)
                                .addGap(260))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(42)
                                .addComponent(lblNewLabel_2)
                                .addGap(46)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userTpye, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(textField_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(42)
                                .addComponent(btnNewButton)
                                .addGap(20)
                                .addComponent(zhuNewButton)
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);

        this.setLocationRelativeTo(null);
    }

    private void loginActionPerformed(ActionEvent arg0) throws Exception {
        String account = this.textField_name.getText();
        String password = this.textField_password.getText();
        if (StringUtil.isEmpty(account)) {
            JOptionPane.showMessageDialog(null, "账号不能为空");
            return;
        }
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }

        String userType = userTpye.getSelectedItem().toString();
        if (userType.equals("用户")) {
            User people = new User(account, password);
            Connection conn = null;
            try {
                conn = dbUtil.getConnection();
                User user = userDao.login(conn, people);
                if (user != null) {
                    dispose();
                    new MainFrm(user).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误！");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Admin admin = new Admin(account, password);
            Connection conn = null;
            try {
                conn = dbUtil.getConnection();
                Admin currentAdmin = adminDao.login(conn, admin);
                if (currentAdmin != null) {
                    dispose();
                    new ManagerFrm(currentAdmin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误！");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                        ;
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    private void registerActionPerformed(ActionEvent arg0) throws Exception {
        String account = this.textField_name.getText();
        String password = this.textField_password.getText();
        if (StringUtil.isEmpty(account)) {
            JOptionPane.showMessageDialog(null, "账号不能为空");
            return;
        } else {
            String regex = "^.{5,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(account);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "用户名长度不小于5个字符");
                return;
            }
        }
        if (StringUtil.isEmpty(password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        } else {
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()])[a-zA-Z\\d!@#$%^&*()]{9,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "密码长度大于8个字符,必须是大小写字母.数字和标点符合的组合");
                return;
            }
        }


        User user = new User(account, password);
        Connection conn = null;
        try {
            conn = dbUtil.getConnection();
            int insert = userDao.register(conn, user);
            if (insert>0) {
                JOptionPane.showMessageDialog(null, "用户注册成功！");
            } else {
                JOptionPane.showMessageDialog(null, "用户注册失败！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }
}
