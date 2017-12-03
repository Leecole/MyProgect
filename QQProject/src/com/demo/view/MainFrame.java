package com.demo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.User;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNickname;
	private User user;

	      
	public MainFrame(User user) {
		this.user=user;
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
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(user.getImagePath()));
		lblNewLabel.setBounds(14, 13, 116, 154);
		panel.add(lblNewLabel);
		
		txtNickname = new JTextField();
		txtNickname.setBackground(new Color(255, 240, 245));
		txtNickname.setText(user.getNickname());
		txtNickname.setBounds(139, 13, 279, 30);
		panel.add(txtNickname);
		txtNickname.setColumns(10);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(new Color(255, 240, 245));
		tabbedPane_1.setBounds(139, 56, 279, 111);
		panel.add(tabbedPane_1);
		
		JPanel signname = new JPanel();
		signname.setBackground(new Color(255, 240, 245));
		
		tabbedPane_1.addTab("个性签名", null, signname, null);
		signname.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 274, 79);
		textArea.setText(user.getSignature());
		signname.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 213, 432, 511);
		contentPane.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(tabbedPane);
		
		JPanel message = new JPanel();//
		tabbedPane.addTab("群组", null, message, null);
		message.setLayout(null);
	
		/*DefaultMutableTreeNode root =new DefaultMutableTreeNode();//定义一个根节点，所有的好友和分组都放这个根节点上
		
		Map<String,HashSet<User>> allFriends=user.getFriends();
		Set<String>  allGroupNames=allFriends.keySet();//获取所有的分组名
		
		for(String groupName:allGroupNames) {//遍历
			DefaultMutableTreeNode  group=new DefaultMutableTreeNode(groupName);//构造出每个组名的对应的TreeNode对象
			HashSet<User>  friendsOfGroup=allFriends.get(groupName);
			for(User u:friendsOfGroup) {
				DefaultMutableTreeNode  friend=new DefaultMutableTreeNode(u.getNickname());
				group.add(friend);
			}
			
			root.add(group);
		}
		JTree tree = new JTree();
		tree.setBounds(0, 0, 425, 477);
		group.add(tree);
		tree.addMouseListener(new MouseAdapter() {//添加鼠标监听事件
			@Override
			public void mouseClicked(MouseEvent e) {//鼠标点击的时候
				if(e.getButton()==1&&e.getClickCount()==2) {//鼠标点击的是左键并且点击次数是双击
					TreePath  path=tree.getSelectionPath();
					DefaultMutableTreeNode lastNode=(DefaultMutableTreeNode)path.getLastPathComponent();
					if(lastNode.isLeaf()) {//叶子
					
						String username=lastNode.toString();
						System.out.println(username);
						ChatFrame   chat=new ChatFrame();
						chat.setVisible(true);
					}
				}
			}
		});
		*/
		
		JPanel friend = new JPanel();
		tabbedPane.addTab("好友", null, friend, null);
		friend.setLayout(null);
		
		//
		DefaultMutableTreeNode root =new DefaultMutableTreeNode();//定义一个根节点，所有的好友和分组都放这个根节点上
		
		Map<String,HashSet<User>> allFriends=user.getFriends();
		Set<String>  allGroupNames=allFriends.keySet();//获取所有的分组名
		
		for(String groupName:allGroupNames) {//遍历
			DefaultMutableTreeNode  group=new DefaultMutableTreeNode(groupName);//构造出每个组名的对应的TreeNode对象
			HashSet<User>  friendsOfGroup=allFriends.get(groupName);
			for(User u:friendsOfGroup) {
				DefaultMutableTreeNode  friends=new DefaultMutableTreeNode(u.getNickname());
				group.add(friends);
			}
			
			root.add(group);
		}
		JTree tree= new JTree();
		tree.setBounds(0, 0, 425, 477);
		friend.add(tree);
		tree.addMouseListener(new MouseAdapter() {//添加鼠标监听事件
			@Override
			public void mouseClicked(MouseEvent e) {//鼠标点击的时候
				if(e.getButton()==1&&e.getClickCount()==2) {//鼠标点击的是左键并且点击次数是双击
					TreePath  path=tree.getSelectionPath();
					DefaultMutableTreeNode lastNode=(DefaultMutableTreeNode)path.getLastPathComponent();
					if(lastNode.isLeaf()) {//叶子
					
						String username=lastNode.toString();
						System.out.println(username);
						ChatFrame   chat=new ChatFrame();
						chat.setVisible(true);
					}
				}
			}
		});
		
		JPanel group = new JPanel();
		tabbedPane.addTab("最近联系人", null, group, null);
		group.setLayout(null);
	}
}
