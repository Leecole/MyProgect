package Bank;

public class Thread1{
	
	public static void main(String[] args) {
		Bank b=new Bank(1000.0f);
		Withdraw cun=new Withdraw(b);
		Drowout qu=new Drowout(b);
		
		cun.start();
		qu.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
