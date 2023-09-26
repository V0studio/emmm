package com.java.ui;

import com.java.dao.AdminDao;
import com.java.dao.UserDao;
import com.java.model.Admin;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserUpdateFrm extends JFrame {
    public static int num;
    private JPanel contentPane;
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
    private UserDao userDao=new UserDao();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserUpdateFrm frame = new UserUpdateFrm(num);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     *
     * @param num
     * @param num
     */
    public UserUpdateFrm(int num) {
        this.num = num;
        setTitle("重置客户密码");
        setBounds(100, 100, 473, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("客户编号:");

        stuidText = new JTextField();
        stuidText.setColumns(10);


        lblNewLabel_2 = new JLabel("姓名:");

        stunameText = new JTextField();
        stunameText.setColumns(10);

        lblNewLabel_3 = new JLabel("");

        lblNewLabel_4 = new JLabel("登录密码:");

        majorText = new JTextField();
        majorText.setColumns(10);

        lblNewLabel_5 = new JLabel("联系电话:");

        classText = new JTextField();
        classText.setColumns(10);

        lblNewLabel_6 = new JLabel("预留字段:");

        entryyearText = new JTextField();
        entryyearText.setColumns(10);

        lblNewLabel_7 = new JLabel("预留字段:");

        phonenumText = new JTextField();
        phonenumText.setColumns(10);

        lblNewLabel_8 = new JLabel("预留字段:");

        emailText = new JTextField();
        emailText.setColumns(10);

        lblNewLabel_9 = new JLabel(" 预留字段:");

        passwordText = new JTextField();
        passwordText.setColumns(10);

        btnNewButton = new JButton("确认");
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

        fillPane();
    }

    private void updateActionPerformed(ActionEvent e) {
        String PeoNo = stuidText.getText();
        String Name = stunameText.getText();
        String Password = majorText.getText();
        String Address = classText.getText();
        if (StringUtil.isEmpty(PeoNo)) {
            JOptionPane.showMessageDialog(null, "编号不能为空");
            return;
        }
        if (StringUtil.isEmpty(Name)) {
            JOptionPane.showMessageDialog(null, "账号不能为空");
            return;
        }
        if (StringUtil.isEmpty(Password)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }else{
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()])[a-zA-Z\\d!@#$%^&*()]{9,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Password);
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "密码长度大于8个字符,必须是大小写字母.数字和标点符合的组合");
                return;
            }
        }
        updateInfo(Integer.valueOf(PeoNo), Name, Password, Address);
        //fillPane();
    }

    private void updateInfo(int PeoNo, String Name, String Password, String Address) {
        User stu = new User();
        stu.setId(PeoNo);
        stu.setAccount(Name);
        stu.setPassword(Password);
        stu.setPhone(Address);
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            int n = userDao.updatebynum(conn, stu);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "修改成功");
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "管理员编号不能重复！");
            return;
            //e.printStackTrace();
        }
    }

    private void fillPane() {
        User stu = new User();
        stu.setId(num);
//		stu.setStuid(StuxinxiFrm.stuid);
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            ResultSet rs = userDao.list(conn, stu);
            if (rs.next()) {
                stuidText.setText(String.valueOf(rs.getInt("id")));
                stunameText.setText(rs.getString("account"));
                majorText.setText("*****");
                classText.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
