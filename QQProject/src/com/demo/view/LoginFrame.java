package com.demo.view;


	import java.awt.BorderLayout;
	import model.MessageBox;
	import model.MessageBox;
	import model.User;
	import com.demo.view.MainFrame;
	import java.awt.EventQueue;
	import java.awt.FocusTraversalPolicy;
	import java.awt.HeadlessException;
	import java.awt.Toolkit;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;



	import Contral.Server;
	
	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import java.awt.Color;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	
	import java.awt.event.ActionListener;
	import java.awt.event.FocusEvent;
	import java.awt.event.FocusListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.net.Socket;
	import java.net.UnknownHostException;
	import java.awt.event.ActionEvent;
	import javax.swing.JToolBar;
	import javax.swing.SwingConstants;
	import java.awt.Dialog.ModalExclusionType;
	import java.awt.Component;
	import javax.swing.DropMode;

	public class LoginFrame  extends JFrame {

		private JPanel contentPane;
		private JTextField username;
		private JPasswordField password;
		private JComboBox comboBox;
		private JPasswordField passwordField;
		private Socket client;
		private ObjectOutputStream out;
		private ObjectInputStream in;
		private MessageBox result;
		


		/**
		 * Launch the application.
		 */
		 /*public void ServerFrame() {
			 ImageIcon im=new ImageIcon("sources/images/1.jpg");
				JLabel lable=new JLabel(im);
		}
		*/
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginFrame frame = new LoginFrame();
						frame.setIconImage(Toolkit.getDefaultToolkit().createImage("sources\\images\\1.jpg"));
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			});
		}

		public LoginFrame(JPanel contentPane) throws HeadlessException {
			super();
			this.contentPane = contentPane;
		}

		/**
		 * Create the frame.
		 */
		public  LoginFrame() {
			setResizable(false);
			setAlwaysOnTop(true);
			setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
			setBackground(new Color(255, 228, 196));
			setForeground(new Color(255, 228, 196));
			setTitle("LoginFrame");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 411);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
		
			
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 13, 430, 363);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(0, 0, 432, 162);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel beijin = new JLabel("New label");
			beijin.setIcon(new ImageIcon("sources\\images\\me_1.PNG"));
			beijin.setBounds(8, -13, 434, 175);
			panel_1.add(beijin);
			
			username = new JTextField("Please input your username");
			username.setBackground(new Color(255, 228, 225));
			username.setToolTipText("账号栏");
			username.addFocusListener(new FocusListener() {//当鼠标聚焦时， 如果文本框中显示的是Please input your username时，则文本框清空，等待用户输入账号
				@Override
				public void focusGained(FocusEvent e) {
					if(username.getText().equals("Please input your username"))
						username.setText("");
				}
				@Override
				public void focusLost(FocusEvent e) {//当鼠标移走的时候，如果用户名为空，则显示Please input your username这个文本提示框
					if(username.getText().length()==0)
						username.setText("Please input your username");
				}
			});
			
			username.setBounds(177, 198, 169, 24);
			panel.add(username);
			username.setColumns(10);
			
			password = new JPasswordField();
			password.setBackground(new Color(255, 228, 225));
			password.setToolTipText("密码框");
			password.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(password.getText().equals("Please input your password"))
						password.setText("");
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(password.getText().length()==0)
						password.setText("请输入您的密码");
				}
			} );
			password.setText("请输入密码");
			password.setBounds(177, 235, 169, 24);
			panel.add(password);
			
			JLabel username = new JLabel("Username");//
			username.setBackground(new Color(0, 204, 51));
			username.setEnabled(false);
			username.setBounds(360, 201, 72, 18);
			panel.add(username);
			
			JLabel password = new JLabel("Password");
			password.setEnabled(false);
			password.setBounds(360, 238, 72, 18);
			panel.add(password);
			
			JButton login = new JButton("Login");
			login.setForeground(new Color(255, 105, 180));
			login.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					login.setForeground(getForeground().blue);
					boolean result=username.getText()==null||password.getText()==null;
					if(result) {
						JOptionPane.showMessageDialog(LoginFrame.this, "账号或者密码不能为空！！ ","提示",JOptionPane.ERROR_MESSAGE);
					}
				
				}
				@Override
				public void focusLost(FocusEvent e) {
					login.setForeground(new Color(255, 105, 180));
				}
			});
			String yourUsername=username.getText().toString().trim();
			String yourPassword=password.getText().toString().trim();
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(yourUsername.length()<2) {
						JOptionPane.showMessageDialog(LoginFrame.this , "账号长度至少六位，请重新输入!","温馨提示",JOptionPane.ERROR_MESSAGE);
						username.requestFocus();
						return ;
						
					}
					else {
						if(yourPassword.length()<2||yourPassword.length()>16) {
							JOptionPane.showMessageDialog(LoginFrame.this , "您输入的密码长度有误，请重新输入!","温馨提示",JOptionPane.ERROR_MESSAGE);
							password.requestFocus();
							return ;
						}
						else {
							if(client==null) {
								try {
									client=new Socket(Server.serverIP,Server.serverPort);
									out=new ObjectOutputStream(client.getOutputStream());
								    in=new ObjectInputStream(client.getInputStream());
								
								} catch (Exception e) {
									e.printStackTrace();
									JOptionPane.showMessageDialog(LoginFrame.this , "无法连接服务器，请检查网络！", "温馨提示", JOptionPane.ERROR_MESSAGE);
								}
								
								try {
									//消息要封装成对象.传递消息要用Object流
									
									
									
									MessageBox  loginMessage=new MessageBox();//把登录消息封装成MessageBox
									User willLoginUser=new User(yourUsername,yourPassword);
									loginMessage.setFrom(willLoginUser);
									loginMessage.setType("login");
									
									//封装完消息后使用序列化流将消息对象写向网络网络另外一端
									out.writeObject(loginMessage);
									out.flush();
									
									//当客户端把登陆消息发送出去后，应该立马读取服务器回发的登陆结果消息
									
									MessageBox  result=(MessageBox)in.readObject();
									if(result.getFrom()==null) {
										JOptionPane.showMessageDialog(LoginFrame.this, "登陆失败,请检查用户名和密码!","温馨提示",JOptionPane.ERROR_MESSAGE);
									}else
									{
										User u=result.getFrom();//服务器给发送者客户端返回一个消息
										MainFrame m=new MainFrame(u);
										m.setVisible(true);
										//LoginFrame.this.setVisible(false);
									}
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								
								
							}
						}
						
						
					}
					
				}
				
				
			});
			login.setBounds(178, 294, 113, 27);
			panel.add(login);
			
			JButton Regiser = new JButton("Regiser");
			
			Regiser.setForeground(new Color(255, 105, 180));
			Regiser.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					login.setForeground(getForeground().blue);
				}
				@Override
				public void focusLost(FocusEvent e) {
					login.setForeground(new Color(255, 105, 180));
				}
			});
			
			Regiser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						if(client==null)
						{
							client=new Socket(Server.serverIP,Server.serverPort);
							out=new ObjectOutputStream(client.getOutputStream());
							in=new ObjectInputStream(client.getInputStream());
						} 
					
					} catch (Exception e1) {
							e1.printStackTrace();
						JOptionPane.showMessageDialog(LoginFrame.this,"无法连接服务器，请检查网络!","温馨提示",JOptionPane.ERROR_MESSAGE);
						return ;
					}
					RegisterFrame r=new RegisterFrame(out,in,LoginFrame.this);
					r.setVisible(true);
					LoginFrame.this.setVisible(false);
				}
			});
			Regiser.setBounds(305, 294, 113, 27);
			panel.add(Regiser);
			
			JLabel touxiang = new JLabel("touxiang");
			touxiang.setBounds(10, 175, 153, 162);
			panel.add(touxiang);
			touxiang.setIcon(new ImageIcon("sources\\images\\猫咪3.jpg"));
			
		}
	


}
