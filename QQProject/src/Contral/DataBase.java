package Contral;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import model.User;

public class DataBase {
	
	
	
	//把对象写入文件夹中 ~~~~~~对象的序列化
	public static boolean register(User user) {
		//新建一个数据通道（文件）
		File data=new File("database1/"+user.getUsername()+".txt");
		if(data.exists()) return false;
		else return updateFile(user);
	}
	public static boolean updateFile(User user) {
		ObjectOutputStream out;//对象输出流，将对象写入到输出流中 out.wirte(); out.close
		try {
			//建立数据通道
			FileOutputStream fos=new FileOutputStream("database1/"+user.getUsername()+".txt");
			
			//建立对象输出流对象
			out = new ObjectOutputStream(fos);//将文件写入database这个文件夹
			out.writeObject(user);
			out.flush();
			out.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	//把文件中的信息读取出来~~~~~~~~对象的反序列化
	public static User login(String username,String password) {
		File data=new File("database1/"+username+".txt");
		
		if(!data.exists()) {//对象不存在时，返回一个空，表示在数据库里找不到当前用户
			return null;
		}
		else {//对象在当前数据库里面存在
			try {
				//建立数据通道 
				FileInputStream fis=new FileInputStream("database1/"+username+"txt");
				
				//对象输入流，从输入流中读取java对象,in.read();
				ObjectInputStream in=new ObjectInputStream(fis);
				
					User u=(User)in.readObject();//把读到的对象传给User
					if(u.getPassword().equals(password)) {
						return u;
					}
					else return null;
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		return null;	
		}	
	} 
	/*public static User searchFriendsByCondition(String username,String nickname) {//查找
	
	}
*/
	public static void main(String[] args) {
		
		User user1=new User("1903502725", "555555", "female",20,"豆奶", "牵本宝宝的手","sources/images/fafa2.PNG");
		User user2=new User("1903502726", "666666", "male",21,"A~bug", "官客户交付好几天","sources/images/fafa3.PNG");
		User user3=new User("1903502727", "777777", "female",22,"撒反对法国", "人d结构接口","sources/images/fafa4.PNG");
		User user4=new User("1903502728", "888888", "male",23,"个人提供fig好吧", "通风后具体看","sources/images/fafa5.PNG");
		User user5=new User("1903502729", "999999", "female",20,"士大夫的电视柜", "人工软件","sources/images/fafa6.PNG");
		User user6=new User("1903502730", "000000", "male",19,"时代的回复", "人噶额是肯定","sources/images/fafa7.PNG");
		User user7=new User("1903502731", "111111", "male",20,"时代的感觉复", "见面会刚吃饭定","sources/images/fafa8.PNG");
		
		
	
	//给user用户封装一个好友列表信息
			Map<String,HashSet<User>>  friend=new HashMap<>();
			HashSet<User>  f1s=new HashSet<>();
					f1s.add(user1);
					f1s.add(user2);
					f1s.add(user3);
					friend.put("best friends", f1s);
					
					
					HashSet<User>  f2s=new HashSet<>();
					f2s.add(user4);
					f2s.add(user5);
					friend.put("大学损友", f2s);
					
					HashSet<User>  f3s=new HashSet<>();
					f3s.add(user6);
					f3s.add(user7);
					
					friend.put("暗恋的对象", f3s);
					
					user1.setFriends(friend);
				
					
			try {
				ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("database1/"+user1.getUsername()+".txt"));
				out.writeObject(user1);
				out.flush();
				out.close();
				
				out=new ObjectOutputStream(new FileOutputStream("database1/"+user2.getUsername()+".txt"));
				out.writeObject(user2);
				out.flush();
				out.close();
				
				out=new ObjectOutputStream(new FileOutputStream("database1/"+user3.getUsername()+".txt"));
				out.writeObject(user3);
				out.flush();
				out.close();
				
				out=new ObjectOutputStream(new FileOutputStream("database1/"+user4.getUsername()+".txt"));
				out.writeObject(user4);
				out.flush();
				out.close();
				out=new ObjectOutputStream(new FileOutputStream("database1/"+user5.getUsername()+".txt"));
				out.writeObject(user5);
				out.flush();
				out.close();
				out=new ObjectOutputStream(new FileOutputStream("database1/"+user6.getUsername()+".txt"));
				out.writeObject(user6);
				out.flush();
				out.close();
				out=new ObjectOutputStream(new FileOutputStream("database1/"+user7.getUsername()+".txt"));
				out.writeObject(user7);
				out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	
}
