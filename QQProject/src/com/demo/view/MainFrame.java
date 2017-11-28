package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNickname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 771);
		setIconImage(Toolkit.getDefaultToolkit().createImage("sources\\images\\4.jpg"));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 432, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("touxiang");
		lblNewLabel.setBounds(14, 13, 116, 154);
		panel.add(lblNewLabel);
		
		txtNickname = new JTextField();
		txtNickname.setBackground(new Color(255, 240, 245));
		txtNickname.setText("nickname");
		txtNickname.setBounds(139, 13, 293, 30);
		panel.add(txtNickname);
		txtNickname.setColumns(10);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(new Color(255, 240, 245));
		tabbedPane_1.setBounds(139, 56, 279, 111);
		panel.add(tabbedPane_1);
		
		JPanel signname = new JPanel();
		signname.setBackground(new Color(255, 240, 245));
		tabbedPane_1.addTab("个性签名", null, signname, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 213, 432, 511);
		contentPane.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel message = new JPanel();//消息
		tabbedPane.addTab("消息", null, message, null);
		message.setLayout(null);
		
		JList list = new JList();
		list.setBackground(new Color(240, 255, 255));
		list.setBounds(0, 0, 425, 477);
		message.add(list);
		
		JPanel friend = new JPanel();
		tabbedPane.addTab("好友", null, friend, null);
		friend.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 0, 425, 477);
		friend.add(tree);
		
		JPanel group = new JPanel();
		tabbedPane.addTab("群组", null, group, null);
		group.setLayout(null);
	}
}
