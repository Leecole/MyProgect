package com.oracle.chatroom.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.oracle.chatroom.config.SocketConfig;
import com.oracle.chatroom.view.ServerFrame;
//这是服务端的后台负责网络链接的类
public class Server {
	private  Map<String,String>  allUsers=new HashMap<>();//定义一个集合，存储当前在线的人的昵称，用于给用户发送过去，让用户界面上能显式在线的用户列表
	
	private ServerSocket  s;
	private ServerFrame  frame;
	public Server(ServerFrame  frame) {
		this.frame=frame;
	}
	public boolean startServer() {//启动服务器
		
		try {
			s=new ServerSocket(SocketConfig.port);
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void  startService() {//开始服务(可以允许客户端链接)
		while(true)
		{
			try {
				Socket client=s.accept();//阻塞方法
				BufferedReader  r=new BufferedReader(new InputStreamReader(client.getInputStream()));
				String username=r.readLine();//
				//如果上面三行代码能运行过来，说明当前肯定有一个客户端链接到服务器了
				//而且这个客户端把他的昵称也发送过来了，（相当于我们这个系统中登陆行为）
				//既然该用户登陆了，那么我们就应该将他的信息存储到服务器端的集合里
				allUsers.put(client.getInetAddress().toString(), username);
				BufferedWriter  out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				out.write(allUsers.values().toString()+"\r\n");
				out.flush();
				frame.getTextArea().append(new Date().toLocaleString()+":\t客户端["+username+"]l连接进来了!\r\n\r\n");
				frame.paintComponents(frame.getGraphics());//绘画组件 updateUI
				System.out.println(client.getInetAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
