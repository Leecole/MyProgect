package Bank;

public class test {//存钱函数
	Bank b=new Bank(1000.0f);
	public Object o=new Object();
	
	public void withdraw(float mon) {
		
		synchronized (o) {
			System.out.println("当前余额为-> "+b.getMoney());
		b.money+=mon;
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("存取后的余额为->"+b.getMoney());
		}
	}
	public void drawout(float mon1) {//取钱函数
	
		synchronized (o) {
			System.out.println("当前余额-> "+b.money);
			b.money-=mon1;
			if(b.money<=0)
				System.out.println("抱歉，余额不足！！！");
			else {
				b.money-=mon1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("取出后的余额为-> "+b.getMoney());
		
			}
		}
		
	}
	
	
}

	
