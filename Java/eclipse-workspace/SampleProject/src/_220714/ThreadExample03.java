package _220714;

class ThreadExample_03_1 extends Thread{
	@Override
	public void run() {
		
		try {
			// 현재 실행 중인 thread 중지
			Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int i = 0; i <300; i++) {
			System.out.print("-");
		}
		System.out.println("thread 1 terminated");
	}
}

class ThreadExample_03_2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i <300; i++) {
			System.out.print("|");
		}
		System.out.println("thread 2 terminated");
	}
}

public class ThreadExample03 {
	public static void main(String[] args) {
		ThreadExample_03_1 t1 = new ThreadExample_03_1();
		ThreadExample_03_2 t2 = new ThreadExample_03_2();
		
		t1.start();
		t2.start();

		
		System.out.println("main thread terminated");
	}
}
