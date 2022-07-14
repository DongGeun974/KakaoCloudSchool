package _220714;

class ThreadEx_06 implements Runnable{
	
	volatile boolean suspended = false;
	volatile boolean stoped = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stoped) {
			if (!suspended)
			{
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}else {
				// for busy waiting
				Thread.yield();
			}
		}
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void stop() {
		stoped = true;
	}
	
	public void resume() {
		suspended = false;
	}
}

public class ThreadExample06 {
	
	public static void main(String[] args) {
		ThreadEx_06 r1 = new ThreadEx_06();
		ThreadEx_06 r2 = new ThreadEx_06();
		ThreadEx_06 r3 = new ThreadEx_06();
		
		Thread t1 = new Thread(r1,"*");			// thread name
		Thread t2 = new Thread(r2,"**");			
		Thread t3 = new Thread(r3,"***");
		
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
