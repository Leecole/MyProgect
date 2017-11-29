package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textfield;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Day = new JPanel();
		Day.setBounds(0, 0, 432, 488);
		contentPane.add(Day);
		Day.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("账号：");
		lblNewLabel.setBounds(25, 39, 55, 18);
		Day.add(lblNewLabel);
		
		textfield = new JTextField();
		textfield.setBounds(98, 30, 306, 32);
		Day.add(textfield);
		textfield.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(23, 78, 62, 25);
		Day.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 75, 306, 33);
		Day.add(passwordField);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 329, 390, 146);
		Day.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextArea SignatureField = new JTextArea();
		SignatureField.setText("您的个性签名！");
		SignatureField.setBounds(0, 0, 385, 114);
		panel_1.add(SignatureField);
		
		JLabel lblNewLabel_2 = new JLabel("昵称：");
		lblNewLabel_2.setBounds(23, 125, 59, 26);
		Day.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("性别：");
		lblNewLabel_3.setBounds(25, 183, 55, 18);
		Day.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("生日:");
		lblNewLabel_4.setBounds(25, 237, 44, 18);
		Day.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 123, 305, 32);
		Day.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("女");
		rdbtnNewRadioButton.setBounds(226, 179, 53, 27);
		Day.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("男");
		rdbtnNewRadioButton_1.setBounds(105, 179, 83, 27);
		Day.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("年");
		lblNewLabel_5.setBounds(153, 236, 23, 18);
		Day.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("月");
		lblNewLabel_6.setBounds(257, 238, 32, 18);
		Day.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("日");
		lblNewLabel_7.setBounds(361, 239, 43, 18);
		Day.add(lblNewLabel_7);
		
		JSpinner Year = new JSpinner();
		Year.setBounds(83, 234, 56, 24);
		Day.add(Year);
		
		JSpinner Mouth = new JSpinner();
		Mouth.setBounds(203, 234, 31, 24);
		Day.add(Mouth);
		
		JSpinner Day1 = new JSpinner();
		Day1.setBounds(303, 234, 31, 24);
		Day1.add(Day1);
	}
}
