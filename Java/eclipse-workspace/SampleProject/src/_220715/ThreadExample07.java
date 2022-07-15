package _220715;

class ThreadEx_07_1 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class ThreadEx_07_2 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
	}
}


public class ThreadExample07 {
	public static void main(String[] args) {
 		Thread t1 = new ThreadEx_07_1();
 		Thread t2 = new ThreadEx_07_2();
 		
 		t1.start();
 		t2.start();
 		
 		try {
 			// 두 thread가 종료할 때까지 main thread는 뒤로 밀림
 			// main block
 			// 내 실행을 멈추고 다른거부터 실행
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
 		
 		System.out.println("main terminated");
	}
}
