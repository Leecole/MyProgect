package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;

public class ChatFrame extends JFrame {
	

	private JPanel contentPane;
	private JTextField Clientnickname;
	private JTextField returnMenuFrame;
	private JPanel sendfield;
	private JTable table_1;
	private AllActionListener listener;
	private JLabel label,label2,label3,label4;
	private User user;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * 
	 */
	
	public ChatFrame(){
		
	}
	
	public ChatFrame(User user) {
		this.user=user;
		setTitle("\u804A\u5929\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 432, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		label=new JLabel();
		label.setText("消息");
		label.setBounds(0, 27, 86, 24);
		panel.add(label);
		
		
		label2=new JLabel();
		label2.setText(user.getNickname());
		label2.setBounds(127, 27, 132, 24);
		panel.add(label2);
		
		 label3 = new JLabel();
		 label3.setBounds(346, 0, 86, 78);
		 label3.setText(user.getImagePath());//将本机登陆的客户信息传递到聊天界面
		 panel.add(label3);
		
		label4 = new JLabel();
		label4.setBounds(127, 30, 132, 10);
		label4.setText(user.getSignature());//将本机登陆的客户信息传递到聊天界面
		panel.add(label4);
		
		
		sendfield = new JPanel();
		sendfield.setBackground(new Color(255, 250, 250));
		sendfield.setBounds(0, 78, 432, 428);
		contentPane.add(sendfield);
		sendfield.setLayout(null);
		
		JButton send = new JButton("send\r\n");
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		send.setBounds(130, 669, 113, 27);
		contentPane.add(send);
		
		JButton close = new JButton("close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/*	~~~~~~~~~*/
			}
		});
		close.setBounds(282, 669, 113, 27);
		contentPane.add(close);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 506, 432, 150);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("表情", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 427, 118);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		JTable table=new JTable(6,8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("抖动", null, panel_3, null);
	}
	class AllActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
	}
}
