import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	 public void ServerFrame() {
		 ImageIcon im=new ImageIcon("sources/images/1.jpg");
			JLabel lable=new JLabel(im);
	}
	
	
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
		
		textField = new JTextField("Please input your account");
		textField.setBounds(177, 198, 169, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField("请输入密码");
		passwordField.setBounds(177, 235, 169, 24);
		panel.add(passwordField);
		
		JLabel username = new JLabel("账号");//账号输入框
		username.setBackground(new Color(0, 204, 51));
		username.setEnabled(false);
		username.setBounds(360, 201, 72, 18);
		panel.add(username);
		
		JLabel password = new JLabel("密码");
		password.setEnabled(false);
		password.setBounds(360, 238, 72, 18);
		panel.add(password);
		
		JButton login = new JButton("登陆");
		login.setBounds(178, 294, 113, 27);
		panel.add(login);
		
		JButton signup = new JButton("注册");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signup.setBounds(305, 294, 113, 27);
		panel.add(signup);
		
		JLabel touxiang = new JLabel("touxiang");
		touxiang.setIcon(new ImageIcon("G:\\AllWorks\\Oracle\\pictures\\猫咪3.jpg"));
		touxiang.setBounds(10, 175, 153, 162);
		panel.add(touxiang);
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\AllWorks\\Oracle\\pictures\\1.jpg"));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, panel, panel_1, beijin, textField, passwordField, username, password, login, signup, touxiang}));
		
	}
}
