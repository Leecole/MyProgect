package model;

import java.io.Serializable;

//把一个Java对象变成字节流的形式传出去，或者从一个字节流中恢复一个Java对象
//序列化：要用到OutputStream类下面的子类ObjectOutput-WriteObject(Object object)

public class MessageBox implements Serializable {//把用户的信息封装成消息盒子，再通过序列化把User变成字节流的形式传出去
	private User from;//传入服务器的用户
	private User to;//服务器传到的目的用户
	private String type;//发送或者接收的类型
	private String content;//发送或者接收的内容
	private String time;//发送或接收的时间
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	//有参构造器
	public MessageBox(User from, User to, String type, String content, String time) {
		super();
		this.from = from;
		this.to = to;
		this.type = type;
		this.content = content;
		this.time = time;
	}
	//无参构造器
	public MessageBox() {
		super();
	}
	@Override
	public String toString() {
		return "MessageBox [from=" + from + ", to=" + to + ", type=" + type + ", content=" + content + ", time=" + time
				+ "]";
	}
	
	
	

}
