package Bank;

public class test {//��Ǯ����
	Bank b=new Bank(1000.0f);
	public Object o=new Object();
	
	public void withdraw(float mon) {
		
		synchronized (o) {
			System.out.println("��ǰ���Ϊ-> "+b.getMoney());
		b.money+=mon;
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��ȡ������Ϊ->"+b.getMoney());
		}
	}
	public void drawout(float mon1) {//ȡǮ����
	
		synchronized (o) {
			System.out.println("��ǰ���-> "+b.money);
			b.money-=mon1;
			if(b.money<=0)
				System.out.println("��Ǹ�����㣡����");
			else {
				b.money-=mon1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ȡ��������Ϊ-> "+b.getMoney());
		
			}
		}
		
	}
	
	
}

	
