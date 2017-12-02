package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
					frame.setIconImage(Toolkit.getDefaultToolkit().createImage("sources\\images\\1.jpg"));
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
	public ChatFrame() {
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
		
		Clientnickname = new JTextField();
		Clientnickname.setText("clientNickname\r\n");
		Clientnickname.setBounds(127, 27, 132, 24);
		panel.add(Clientnickname);
		Clientnickname.setColumns(10);
		
		JLabel clientInformation = new JLabel("clientInformation\r\n");
		clientInformation.setIcon(new ImageIcon("sources\\images\\clientMessage.PNG"));
		clientInformation.setBounds(346, 0, 86, 78);
		panel.add(clientInformation);
		
		returnMenuFrame = new JTextField();
		returnMenuFrame.setText("<Message");
		returnMenuFrame.setBounds(0, 27, 86, 24);
		panel.add(returnMenuFrame);
		returnMenuFrame.setColumns(10);
		
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
			}
		});
		close.setBounds(282, 669, 113, 27);
		contentPane.add(close);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 506, 432, 150);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("\u8868\u60C5\u5305\u96C6\u5408");
		tabbedPane.addTab("�����", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 427, 118);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		JTable table=new JTable(6,8);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("ͼƬ", null, panel_3, null);
	}
}
