import java.io.IOException;
import java.net.ServerSocket;

public class Server {
		
	public static void main(String[] args) {
		
	
	 	while (true) {
	 		try {
				@SuppressWarnings("resource")
				ServerSocket server = new ServerSocket(8888);
	 			server.accept();
	 			System.out.println("有新用户连接进来了");
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 	}
	}
}
