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

import org.eclipse.wb.swing.FocusTraversalOnArray;

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

public class ServerFrame extends JFrame {

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
					ServerFrame frame = new ServerFrame();
					frame.setIconImage(Toolkit.getDefaultToolkit().createImage("sources\\images\\1.jpg"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	public ServerFrame(JPanel contentPane) throws HeadlessException {
		super();
		this.contentPane = contentPane;
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setResizable(false);
		setAlwaysOnTop(true);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setBackground(new Color(255, 228, 196));
		setForeground(new Color(255, 228, 196));
		setTitle("登陆界面");
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
		beijin.setIcon(new ImageIcon("G:\\AllWorks\\Oracle\\pictures\\me_1.PNG"));
		beijin.setBounds(8, -13, 434, 175);
		panel_1.add(beijin);
		
		username = new JTextField("Please input your username");
		username.setBackground(new Color(255, 228, 225));
		username.addKeyListener(new KeyListener(){//控制台输出正在输入的事件
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("您输入的用户名\n"+username.getText());
			}
		});
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
		password.setToolTipText("\u8BF7\u8F93\u5165\u5BC6\u7801");
		password.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(password.getText().equals("请输入密码"))
					password.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(password.getText().length()==0)
					password.setText("请输入密码");
			}
		} );
		password.setText("请输入密码");
		password.setBounds(177, 235, 169, 24);
		panel.add(password);
		
		JLabel username = new JLabel("账号");//账号输入框
		username.setBackground(new Color(0, 204, 51));
		username.setEnabled(false);
		username.setBounds(360, 201, 72, 18);
		panel.add(username);
		
		JLabel password = new JLabel("密码");
		password.setEnabled(false);
		password.setBounds(360, 238, 72, 18);
		panel.add(password);
		
		JButton login = new JButton("登录");
		login.setForeground(new Color(255, 105, 180));
		login.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				login.setForeground(getForeground().blue);
				boolean result=username.getText()!=null&&password.getText()!=null;
				if(result) {
					JOptionPane.showMessageDialog(ServerFrame.this ,result?"登录成功":"登录失败" );//弹出一个消息提示框，
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				login.setForeground(new Color(255, 105, 180));
			}
		});
		login.setBounds(178, 294, 113, 27);
		panel.add(login);
		
		JButton signup = new JButton("注册");
		signup.setForeground(new Color(255, 105, 180));
		
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signup.setBounds(305, 294, 113, 27);
		panel.add(signup);
		
		JLabel touxiang = new JLabel("touxiang");
		touxiang.setIcon(new ImageIcon("G:\\AllWorks\\Oracle\\pictures\\\u732B\u54AA3.jpg"));
		touxiang.setBounds(10, 175, 153, 162);
		panel.add(touxiang);
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\AllWorks\\Oracle\\pictures\\1.jpg"));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, panel, panel_1, beijin, username, password, username, password, login, signup, touxiang}));
		
	}
}
