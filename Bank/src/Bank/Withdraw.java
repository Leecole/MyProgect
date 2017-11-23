package Bank;

public class Withdraw extends Thread {
	private Bank c;

	public Withdraw(Bank c) {
		super();
		this.c = c;
	}


	@Override
	public void run() {
		c.withdraw(300.0f);
	}

}
