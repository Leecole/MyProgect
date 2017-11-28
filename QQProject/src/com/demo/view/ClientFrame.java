package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JList;

public class ClientFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 180);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 213, 432, 511);
		contentPane.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel message = new JPanel();//��Ϣ
		tabbedPane.addTab("��Ϣ", null, message, null);
		message.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 425, 477);
		message.add(list);
		
		JPanel friend = new JPanel();
		tabbedPane.addTab("����", null, friend, null);
		friend.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 0, 425, 477);
		friend.add(tree);
		
		JPanel group = new JPanel();
		tabbedPane.addTab("Ⱥ��", null, group, null);
		group.setLayout(null);
	}
}
