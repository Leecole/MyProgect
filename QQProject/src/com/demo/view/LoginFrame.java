package com.demo.view;


	import java.awt.BorderLayout;
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


	import javax.swing.JTextField;
	import javax.swing.JPasswordField;
	import java.awt.Color;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.FocusEvent;
	import java.awt.event.FocusListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
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
			setTitle("LoginFrmae");
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
			username.addKeyListener(new KeyListener(){//����̨�������������¼�
				@Override
				public void keyPressed(KeyEvent e) {}
				@Override
				public void keyReleased(KeyEvent e) {}
				@Override
				public void keyTyped(KeyEvent e) {
					System.out.println("��������û���\n"+username.getText());
				}
			});
			username.addFocusListener(new FocusListener() {//�����۽�ʱ�� ����ı�������ʾ����Please input your usernameʱ�����ı�����գ��ȴ��û������˺�
				@Override
				public void focusGained(FocusEvent e) {
					if(username.getText().equals("Please input your username"))
						username.setText("");
				}
				@Override
				public void focusLost(FocusEvent e) {//��������ߵ�ʱ������û���Ϊ�գ�����ʾPlease input your username����ı���ʾ��
					if(username.getText().length()==0)
						username.setText("Please input your username");
				}
			});
			
			username.setBounds(177, 198, 169, 24);
			panel.add(username);
			username.setColumns(10);
			
			password = new JPasswordField();
			password.setBackground(new Color(255, 228, 225));
			password.setToolTipText("\u8BF7\u8F93\u5165\u5BC6\u7801");
			password.addFocusListener(new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if(password.getText().equals("����������"))
						password.setText("");
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(password.getText().length()==0)
						password.setText("����������");
				}
			} );
			password.setText("����������");
			password.setBounds(177, 235, 169, 24);
			panel.add(password);
			
			JLabel username = new JLabel("Username");//�˺������
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
					boolean result=username.getText()!=null&&password.getText()!=null;
					if(result) {
						JOptionPane.showMessageDialog(LoginFrame.this ,result?" Login Successfully ":"Login Failure" );//����һ����Ϣ��ʾ��
					}
				
				}
				@Override
				public void focusLost(FocusEvent e) {
					login.setForeground(new Color(255, 105, 180));
				}
			});
			login.setBounds(178, 294, 113, 27);
			panel.add(login);
			
			JButton Regiser = new JButton("Regiser");
			Regiser.setForeground(new Color(255, 105, 180));
			
			Regiser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
