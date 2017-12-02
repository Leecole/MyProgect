package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import java.awt.Color;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private LoginFrame login;

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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton.setBounds(133, 145, 55, 27);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1.setBounds(275, 145, 55, 27);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel label = new JLabel("生日:");
		label.setBounds(27, 201, 38, 18);
		panel.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(95, 198, 55, 24);
		panel.add(spinner);
		
		JLabel lblNewLabel_3 = new JLabel("年");
		lblNewLabel_3.setBounds(154, 201, 23, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("月");
		lblNewLabel_4.setBounds(240, 201, 30, 18);
		panel.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("日");
		label_1.setBounds(334, 201, 72, 18);
		panel.add(label_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(177, 198, 55, 24);
		panel.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(275, 198, 55, 24);
		panel.add(spinner_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 434, 432, 230);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("个性签名", null, panel_1, null);
		panel_1.setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(255, 228, 225));
		editorPane.setForeground(new Color(255, 255, 255));
		editorPane.setBounds(0, 0, 427, 198);
		panel_1.add(editorPane);
		
		JLabel lblNewLabel_5 = new JLabel("昵称:");
		lblNewLabel_5.setBounds(25, 259, 38, 18);
		panel.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(77, 256, 311, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("邮箱:");
		lblNewLabel_6.setBounds(25, 340, 44, 18);
		panel.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 328, 308, 34);
		panel.add(textField_2);
		textField_2.setColumns(10);
	}

}
