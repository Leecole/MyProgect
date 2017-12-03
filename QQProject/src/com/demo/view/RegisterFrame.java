package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.demo.view.LoginFrame;

import Contral.DataBase;
import model.MessageBox;
import model.User;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField,nickname;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private LoginFrame login;
	private JRadioButton radioButton,radioButton_1;
	private JTextField textField_3;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RegisterFrame(ObjectOutputStream out, ObjectInputStream in, LoginFrame login) {
		this.out=out;
		this.in=in;
		this.login=login;
		setIconImage(Toolkit.getDefaultToolkit().createImage("sources\\images\\1.jpg"));
		setBackground(new Color(255, 228, 225));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 3, 432, 664);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号:");
		lblNewLabel.setBounds(25, 49, 38, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密码:");
		lblNewLabel_1.setBounds(27, 99, 38, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("性别:");
		lblNewLabel_2.setBounds(25, 149, 38, 18);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(77, 36, 311, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 83, 309, 34);
		panel.add(passwordField);
		
		JLabel label = new JLabel("年龄:");
		
		
		label.setBounds(27, 201, 38, 18);
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 434, 432, 230);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		tabbedPane.addTab("个性签名", null, panel_1, null);
		panel_1.setLayout(null);
		
		comboBox = new JComboBox();
		for (int i = 1; i <9; i++) {
			comboBox.addItem(i+"");
		}
		comboBox.setBounds(25, 275, 56, 18);
		contentPane.add(comboBox);
	
		JEditorPane editorPane = new JEditorPane();
		
		editorPane.setBackground(new Color(255, 228, 225));
		editorPane.setForeground(Color.BLACK);
		editorPane.setBounds(0, 0, 427, 143);
		panel_1.add(editorPane);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setBounds(37, 156, 113, 27);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String yonghuming=lblNewLabel.getText().trim();
				String mima=lblNewLabel_1.getText();
				String sex=radioButton.isSelected()?"Male":"Female";
				int age=Integer.parseInt(comboBox.getSelectedItem().toString());
				String nicheng=nickname.getText().trim();//
				String touxiang="resources/images/荣1.jpg";
				String qianming=editorPane.getText().toString();
				User  u=new User(yonghuming, mima, sex, age, nicheng, qianming,touxiang);//将注册的用户信息打包
				System.out.println(u);
				DataBase.login(u);
				MessageBox  registerMessage=new MessageBox();
				registerMessage.setFrom(u);
				registerMessage.setType("register");
				/*btnNewButton.addFocusListener(new FocusListener() {

					@Override
					public void focusGained(FocusEvent arg0) {
						
						ptionPane.showMessageDialog("RegisterFrame.this", "");
						}
					}

					@Override
					public void focusLost(FocusEvent arg0) {
						
					}
					
				});
				*/
				//使用序列化写给服务器，让服务器注册
				try {
					RegisterFrame.this.out.writeObject(registerMessage);
					RegisterFrame.this.out.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("send end");
				
				//根据服务器回复的注册消息进一步跳转界面
				MessageBox result=null;
				try {
					result = (MessageBox)RegisterFrame.this.in.readObject();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(RegisterFrame.this, "注册"+(result.getContent().equals("true")?"成功":"失败"),"温馨提示",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
			
		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(165, 42, 42));
		btnNewButton_1.setBounds(254, 156, 113, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterFrame.this.login.setVisible(true);//调到登陆界面
				RegisterFrame.this.setVisible(false);//原来的注册界面消失
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JLabel nickname = new JLabel("昵称:");
		nickname.setBounds(26, 356, 38, 18);
		panel.add(nickname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 349, 311, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setBounds(105, 145, 72, 27);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setBounds(246, 145, 78, 27);
		panel.add(radioButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(75, 197, 56, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		
		
	}
}
