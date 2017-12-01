package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().createImage("sources\\images\\1.jpg"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 0, 609, 639);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 25, 206, 24);
		textField.setText("在线用户列表\r\n");
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 25, 356, 24);
		textField_1.setText("所有用户在线的列表");
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 68, 206, 448);
		panel.add(scrollPane);
		
		JTextArea txtrip = new JTextArea();
		txtrip.setText("登陆IP");
		scrollPane.setRowHeaderView(txtrip);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("用户昵称");
		scrollPane.setViewportView(textArea);
		
		textField_2 = new JTextField();
		textField_2.setBounds(239, 62, 356, 457);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 228, 225));
		tabbedPane.setBounds(0, 544, 609, 105);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("基本控制", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("启动服务器");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(95, 13, 113, 27);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("断开服务器");
		btnNewButton_1.setBounds(283, 13, 113, 27);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("高级控制", null, panel_2, null);
	}
}

