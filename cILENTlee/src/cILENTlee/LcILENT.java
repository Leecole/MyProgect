package cILENTlee;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LcILENT {
	public static void main(String[] args) {
		
		try {
			Socket cilent=new Socket("localhost",9999);
			System.out.println("���Ѿ������˷�����");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
