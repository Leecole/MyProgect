package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Contral.DataBase;

import Contral.Server;
import model.MessageBox;
import model.User;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ServerFrame extends JFrame {

	private ServerSocket server;
	private ServerFrame frame;
	
	private AllButtonListener listener;
	private TableModel  model;
	private JTable table;
	private Object[] tableTitle=new Object[]{"登陆IP","用户昵称"};
	private JPanel contentPane;
	
	private JLabel lblNewLabel,lblNewLabel_1;
	private JScrollPane  scrollPane;
	private JTextArea textArea;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private  JButton  button1,button2;
	private MessageBox loginResult,registerResultMessage,m;
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
	{
		listener=new AllButtonListener();
	}
	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 686);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("在线用户列表");
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.white));
		lblNewLabel.setBounds(18, 13, 241, 23);
		contentPane.add(lblNewLabel);
		
		model=new DefaultTableModel(tableTitle,0) ;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 0, 609, 639);
		contentPane.add(panel);
		panel.setLayout(null); 
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 228, 225));
		tabbedPane.setBounds(0, 544, 609, 105);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		tabbedPane.addTab("基本控制", null, panel_1, null);
		panel_1.setLayout(null);
		
		button1 = new JButton("启动服务器");
		button1.addActionListener(listener);
		LoginFrame l=new LoginFrame(); 
		button1.setBounds(95, 13, 113, 27);
		panel_1.add(button1);
		
		button2 = new JButton("断开服务器");
		button2.setEnabled(false);
		button2.addActionListener(listener);
		button2.setBounds(283, 13, 113, 27);
		panel_1.add(button2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("高级控制", null, panel_2, null);
		
		textArea = new JTextArea();
		textArea.setBounds(299, 51, 294, 453);
		panel.add(textArea);
		textArea.setEditable(false);
		
		
		lblNewLabel_1 = new JLabel("所有用户发送的消息列表");
		lblNewLabel_1.setBounds(299, 13, 296, 25);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.gray));
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(24, 51, 241, 457);
		panel.add(scrollPane);
	}
	class AllButtonListener implements ActionListener{//所有按钮的监听事件

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1) {//button1的事件源
				
				//连接服务器的端口
				try {
					server=new ServerSocket(Server.serverPort);
					button1.setEnabled(false);//点击了服务器启动这个按钮后，按钮变为灰色，不能再次点击；
					button2.setEnabled(true);//这时候断开服务器这个按钮可以用；
					
					//弹出一个消息框
					JOptionPane.showMessageDialog(ServerFrame.this, "服务器启动成功！", "温馨提示", JOptionPane.INFORMATION_MESSAGE);
					
					//启动按钮之外，服务器还要开启对外开放；
					new Thread() {
							public void run() {
								while(true) {//只要有客户端接进来，服务器就连接
									try {
										Socket s=server.accept();
										System.out.println(s.getInetAddress());//获取连接进来的客户端的ip地址
										ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());//把新连接进来的客户信息对象通过输出流来写入
										ObjectInputStream  in=new  ObjectInputStream(s.getInputStream());//把新连接进来的客户对像通过输入流读取
										ClientMessageReciveThread  thisClientThread=new ClientMessageReciveThread(out,in);
										thisClientThread.start();
									}catch (Exception e2) {
									}
								}
							}
					}.start();
			
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ServerFrame.this, "啊噢~服务器启动失败","温馨提示",JOptionPane.ERROR_MESSAGE);
				}
				
			}else if(e.getSource()==button2) {
				int n=JOptionPane.showConfirmDialog(ServerFrame.this,"您确定要关闭服务器吗？","温馨提示" ,JOptionPane.OK_CANCEL_OPTION);
				if(n==0) {//如果客户点击Cancel（表示等于0） 则关闭当前的服务器
					try {
						server.close();
						button1.setEnabled(true);//服务器关闭，登录服务器按钮变为可用，
						button2.setEnabled(false);//断开服务器按钮变为不可用
						JOptionPane.showMessageDialog(ServerFrame.this, "服务器已经关闭!", "温馨提示", JOptionPane.WARNING_MESSAGE);
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}		
			}
			
			
		}
	}
	class ClientMessageReciveThread extends Thread{//客户消息接收线程
		private ObjectOutputStream  out;
		private ObjectInputStream in;
		public ClientMessageReciveThread(ObjectOutputStream out, ObjectInputStream in) {
			super();
			this.out = out;
			this.in = in;
		}
		@Override
			public void run() {
				try {
					while(true) {//一直读取客户端发送过来的消息
					
						 m=(MessageBox)in.readObject();//当前线程接收一个来自客户端的发送过来的一个messagebox对象
						System.out.println(m);
						if(m.getType().equals("login")) {
							processLoginMessage(m);
						}
						if(m.getType().equals("register")) {
							processRegisterMessage(m);
						}
						if(m.getType().equals("addFriend")) {
						}
						if(m.getType().equals("search")) {
							
						}
						if(m.getType().equals("update")) {
						
						}
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
					
				}
		private void processLoginMessage(MessageBox m) {//链接数据判断用户登录信息是否正确
			User loginUser=DataBase.login(m.getFrom().getUsername(), m.getFrom().getPassword());
			if(loginUser!=null) {//如果登录成功，需要更新服务器窗口上显示的用户信息列表
				model=new DefaultTableModel(new Object[][] {{loginUser.getUsername(),loginUser.getNickname()}},tableTitle ) ;
				table.setModel(model);	
			}
			//登录之后服务器应该给发送者。也就是User.from返回一个信息，也用MessageBox封装
			loginResult=new MessageBox();
			loginResult.setFrom(loginUser);
			loginResult.setType("loginResult");
			try {
				out.writeObject(loginResult);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private void processRegisterMessage(MessageBox m) {
			
			User  willResgisterUser=m.getFrom();
			Boolean result=DataBase.register(willResgisterUser);
			
			registerResultMessage=new MessageBox();
			registerResultMessage.setContent(result.toString());
			registerResultMessage.setType("registerResult");
			try {
				out.writeObject(registerResultMessage);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}

