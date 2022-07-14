package _220714;

class MyThread extends Thread{
	@Override
	public void run() {
		System.out.println("hello");
	}
}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("이것도 실행");
	}
	
}

public class ThreadPractice {
	public static void main(String[] args) {
		
		MyThread t = new MyThread();
//		t.run();		// main() 위에 호출, main thread 스택에서 실행
		t.start();		// main() 위에 호출, 새로운 thread 생성, 새로운 스택에서 run()
		
		
		MyThread2 a = new MyThread2();
		Thread t1 = new Thread(a);
		t1.start();
		
		System.out.println("안녕");
	}
}
