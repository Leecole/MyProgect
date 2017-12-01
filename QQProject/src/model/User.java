package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

public class User implements Serializable{ //序列化：把一个Java对象写入到硬盘或者传输到网路上面的其它计算机，这时我们就需要自己去通过java把相应的对象写成转换成字节流
	private String username;
	private String password;
	private String sex;
	private int age;
	private String nickname;//昵称
	private String signature;//签名
	private String imagePath;//图片
	private Map<String ,HashSet<User>> friends;//创建一个Map属性来承装Uesr对象
			// 用户的朋友分组,   //分组里面每个朋友的信息集合
	
	public String getUsername() {
		return username;
	}

	public User(String username, String password,String nickname) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Map<String, HashSet<User>> getFriends() {
		return friends;
	}
	public void setFriends(Map<String, HashSet<User>> friends) {
		this.friends = friends;
	}
	public User(String string, String string2, String string3, int i, String string4, String string5, String string6) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.nickname = nickname;
		this.signature = signature;
		this.imagePath = imagePath;
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String sex, int age, String nickname, String signature,
			String imagePath, Map<String, HashSet<User>> friends) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.nickname = nickname;
		this.signature = signature;
		this.imagePath = imagePath;
		this.friends = friends;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", sex=" + sex + ", age=" + age + ", nickname="
				+ nickname + ", signature=" + signature + ", imagePath=" + imagePath + ", friends=" + friends + "]";
	}
}
