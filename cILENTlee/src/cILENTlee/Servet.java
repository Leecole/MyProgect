package cILENTlee;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servet {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(9999);
			
			Socket c=server.accept();
			System.out.println("�����û����ӽ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
