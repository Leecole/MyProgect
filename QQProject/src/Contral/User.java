package Contral;

public class User {
	private String nickname;

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public User(String nickname) {
		super();
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

}
