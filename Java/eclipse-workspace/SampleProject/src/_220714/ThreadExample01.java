package _220714;

class ThreadEx_01_1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
			System.out.println(getName());
		}
	}
}

class ThreadEx_01_2 implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread());
		}
	}
}

public class ThreadExample01 {
	public static void main(String[] args) {
		ThreadEx_01_1 t1 = new ThreadEx_01_1();
		
		ThreadEx_01_2 r = new ThreadEx_01_2();
		Thread t2 = new Thread(r);
		
		// 우선순위
		// multi core 환경에서는 의미 없음
		t1.setPriority(2);			
		t2.setPriority(4);
		
		t1.start();
		t2.start();
		
		System.out.println("end of main");
	}
}
