package com.oracle.chatroom.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ChatFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame(new String[] {"adsa"});
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
	public ChatFrame(String[] allOnlineUsers) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 164, 501);
		contentPane.add(scrollPane);
		
		JList list = new JList(allOnlineUsers);
		scrollPane.setColumnHeaderView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(195, 10, 524, 231);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(195, 261, 524, 152);
		contentPane.add(textArea_1);
		
		JButton button = new JButton("发送");
		button.setBounds(333, 457, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("抖动");
		button_1.setBounds(461, 457, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("关闭");
		button_2.setBounds(590, 457, 93, 23);
		contentPane.add(button_2);
	}
}
