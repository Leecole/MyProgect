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
			System.out.println("��ǰ���Ϊ-> "+this.getMoney());
			money+=mon;
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�������Ϊ->"+this.getMoney());
		}
	}
	public void drawout(float mon) {//ȡǮ����
	
		synchronized (o) {
			System.out.println("��ǰ���-> "+this.getMoney());
			money-=mon;
			if(money<=0)
				System.out.println("��Ǹ�����㣡����");
			else {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ȡ��������Ϊ-> "+this.getMoney());
				System.out.println("�����˻����Ϊ��"+this.getMoney());
				
		
			}
		}
		
	}
	

	

	

	
}
