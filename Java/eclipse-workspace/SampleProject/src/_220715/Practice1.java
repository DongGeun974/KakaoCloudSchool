package _220715;

// 1초마다 자신의 이름을 호출하는 thread 2개 생성
// 이름을 출력할 때 교대로 출력하는 것을 보장

class MyThread implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0 ; i < 2; i++) {
			try {
				print(i);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public synchronized void print(int i) throws InterruptedException {
		notify();
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName());
		if (i != 1)
		{
			wait();
		}
		
	}
}

public class Practice1 {
	public static void main(String[] args) {
		MyThread r = new MyThread();
		
		Thread t1 = new Thread(r, "1번재");
		Thread t2 = new Thread(r, "2번째");
		
		t1.start();
		t2.start();
		
	}
}
