package Bank;

public class Bank extends Thread {
	public static  float money;
	
	public Object o=new Object();
	
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
	public  Bank(float money) {
		
		this.money = money;
	}
	

	public void withdraw(float mon) {
		
		synchronized (o) {
			System.out.println("当前余额为-> "+this.getMoney());
			money+=mon;
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("存后的余额为->"+this.getMoney());
		}
	}
	public void drawout(float mon) {//取钱函数
	
		synchronized (o) {
			System.out.println("当前余额-> "+this.getMoney());
			money-=mon;
			if(money<=0)
				System.out.println("抱歉，余额不足！！！");
			else {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("取出后的余额为-> "+this.getMoney());
				System.out.println("您的账户余额为："+this.getMoney());
				
		
			}
		}
		
	}
	

	

	

	
}
