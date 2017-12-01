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
		File data=new File("database/"+user.getUsername()+".qq");
		if(data.exists()) return false;
		else return updateFile(user);
	}
	public static boolean updateFile(User user) {
		ObjectOutputStream out;//对象输出流，将对象写入到输出流中 out.wirte(); out.close
		try {
			//建立数据通道
			FileOutputStream fos=new FileOutputStream("database/"+user.getUsername()+".qq");
			
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
		File data=new File("database/"+username+".qq");
		
		if(!data.exists()) {//对象不存在时，返回一个空，表示在数据库里找不到当前用户
			return null;
		}
		else {//对象在当前数据库里面存在
			try {
				//建立数据通道 
				FileInputStream fis=new FileInputStream("database/"+username+".qq");
				
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
		
		User user1=new User("111", "111", "female",20,"豆奶", "牵本宝宝的手","sources/images/fafa2.PNG");
		User user2=new User("222", "222", "male",21,"A~bug", "官方了人体后i好几天","sources/images/fafa3.PNG");
		User user3=new User("333", "333", "female",22,"撒反对法国", "人d结构接口","sources/images/fafa4.PNG");
		User user4=new User("444", "444", "male",23,"个人提供fig好吧", "通风后具体看","sources/images/fafa5.PNG");
		User user5=new User("555", "555", "female",20,"士大夫的电视柜", "人工软件","sources/images/fafa6.PNG");
		User user6=new User("666", "666", "male",19,"时代的回复", "人噶额是肯定","sources/images/fafa7.PNG");
		
		
	
	//给user用户封装一个好友列表信息
			Map<String,HashSet<User>>  friend=new HashMap<>();
			HashSet<User>  f1s=new HashSet<>();
					f1s.add(user1);
					f1s.add(user2);
					f1s.add(user3);
					friend.put("老铁们", f1s);
					
					
					HashSet<User>  f2s=new HashSet<>();
					f2s.add(user4);
					f2s.add(user5);
					friend.put("大学损友", f2s);
					
					HashSet<User>  f3s=new HashSet<>();
					f3s.add(user6);
					
					friend.put("暗恋的对象", f3s);
					
					user1.setFriends(friend);
				
					
			try {
				ObjectOutputStream  out=new ObjectOutputStream(new FileOutputStream("database/"+user1.getUsername()+".qq"));
				out.writeObject(user1);
				out.flush();
				out.close();
				
				out=new ObjectOutputStream(new FileOutputStream("database/"+user2.getUsername()+".qq"));
				out.writeObject(user2);
				out.flush();
				out.close();
				
				out=new ObjectOutputStream(new FileOutputStream("database/"+user3.getUsername()+".qq"));
				out.writeObject(user3);
				out.flush();
				out.close();
				
				out=new ObjectOutputStream(new FileOutputStream("database/"+user4.getUsername()+".qq"));
				out.writeObject(user4);
				out.flush();
				out.close();
				out=new ObjectOutputStream(new FileOutputStream("database/"+user5.getUsername()+".qq"));
				out.writeObject(user5);
				out.flush();
				out.close();
				out=new ObjectOutputStream(new FileOutputStream("database/"+user6.getUsername()+".qq"));
				out.writeObject(user6);
				out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	
}
