package Bank;

public class Drowout extends Thread {
	private Bank c;

	public Drowout(Bank c) {
		
		this.c = c;
	}

	@Override
	public void run() {
		c.drawout(1000.0f);
	}

	

}
