package _220715;

// Thread에 의해서 공유되는 공유 객체 생성하기 위한 class
class Account{
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	// 동기화 처리
//	public synchronized void withdraw(int money) {
//		if (balance >= money) {
//			// -balance 발생
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//			balance -= money;
//		}
//	}
	
	public void withdraw(int money) {
		// 동기화 처리
		synchronized (this) {
			if (balance >= money) {
				// -balance 발생
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				balance -= money;
			}	
		}
	}
	
}

class ThreadEx_09 implements Runnable{
	
	Account acc = new Account();
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1)*100;
			acc.withdraw(money);
			System.out.println("남은 잔액 : " + acc.getBalance() );
		}
	}
}

public class ThreadExample09 {
	public static void main(String[] args) {
		ThreadEx_09 r= new ThreadEx_09();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
	}
}
