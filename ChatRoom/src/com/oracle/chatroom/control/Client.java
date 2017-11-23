package com.oracle.chatroom.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.oracle.chatroom.config.SocketConfig;
import com.oracle.chatroom.view.ClientLoginFrame;

public class Client {
	private Socket  client;
	private BufferedReader  in;
	/**
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}

	private BufferedWriter  out;
	private ClientLoginFrame  frame;
	public Client(ClientLoginFrame  frame) {
		this.frame=frame;
	}
	
	public boolean connectServer() {
		try {
			client=new Socket(SocketConfig.serverIP, SocketConfig.port);
			out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			in=new BufferedReader(new InputStreamReader(client.getInputStream()));
//			System.out.println(frame.getTextField_1().getText());
			out.write(frame.getTextField_1().getText()+"\r\n");
			out.flush();
			System.out.println("send ok");
			
			//BUfferedWriter如果需要将某些文字立马写入到对方的Reader中，必须输入换行符和flush
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}

}
