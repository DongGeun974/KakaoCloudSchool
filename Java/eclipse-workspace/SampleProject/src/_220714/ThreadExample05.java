package _220714;

class ThreadEx_05 implements Runnable{
	
	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

public class ThreadExample05 {
	public static void main(String[] args) {
		ThreadEx_05 r = new ThreadEx_05();
		
		Thread t1 = new Thread(r,"*");			// thread name
		Thread t2 = new Thread(r,"**");			
		Thread t3 = new Thread(r,"***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t1.suspend();
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(2000);
			t1.resume();
			Thread.sleep(2000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
