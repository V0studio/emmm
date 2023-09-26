package com.java.ui;

import com.java.model.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm(null);
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
	public MainFrm(User user) {
		setTitle("用户界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);

		JMenu kaoqin = new JMenu("密码管理");
		menuBar.add(kaoqin);

		JMenuItem kqxinxi = new JMenuItem("密码管理详情");
		kqxinxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserTwoFrm userTwoFrm=new UserTwoFrm(user);
				userTwoFrm.setVisible(true);
				table.add(userTwoFrm);
			}
		});
		kaoqin.add(kqxinxi);

		JMenu adminkaoqin = new JMenu("商品信息");
		menuBar.add(adminkaoqin);

		JMenuItem adminkqchaxun = new JMenuItem("商品列表");
		adminkqchaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodTwoFrm goodFrm=new GoodTwoFrm(user);
				goodFrm.setVisible(true);
				table.add(goodFrm);
			}
		});
		adminkaoqin.add(adminkqchaxun);


        JMenu goodmenu = new JMenu("购物管理");
        menuBar.add(goodmenu);

        JMenuItem gooditem = new JMenuItem("购物车详情");
        gooditem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CartFrm cartFrm=new CartFrm(user);
                cartFrm.setVisible(true);
                table.add(cartFrm);
            }
        });
        goodmenu.add(gooditem);

		JMenu orderM = new JMenu("订单管理");
		menuBar.add(orderM);

		JMenuItem orderI = new JMenuItem("订单详情");
		orderI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderFrm orderFrm=new OrderFrm(user);
				orderFrm.setVisible(true);
				table.add(orderFrm);
			}
		});
		orderM.add(orderI);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);//界面最大化
	}

}
