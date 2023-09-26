package com.java.ui;

import com.java.model.Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrm frame = new ManagerFrm(null);
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
	public ManagerFrm(Admin admin) {
		setTitle("管理员界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_2 = new JMenu("客户管理");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("客户信息");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserFrm userFrm=new UserFrm(admin);
				userFrm.setVisible(true);
				table.add(userFrm);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenu adminkaoqin = new JMenu("商品管理");
		menuBar.add(adminkaoqin);
		
		JMenuItem adminkqchaxun = new JMenuItem("商品信息");
		adminkqchaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodFrm goodFrm=new GoodFrm();
				goodFrm.setVisible(true);
				table.add(goodFrm);
			}
		});
		adminkaoqin.add(adminkqchaxun);


		JMenu mnNewMenu_1 = new JMenu("密码管理");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("管理员信息");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrm adminFrm=new AdminFrm();
				adminFrm.setVisible(true);
				table.add(adminFrm);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 251, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//界面最大化
	}
}
