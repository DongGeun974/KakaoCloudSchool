package _220714;


// Daemon Thread
public class ThreadExample02 implements Runnable {
	
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new ThreadExample02());
		
		t.setDaemon(true);
		
		t.start();
		
		for(int i = 0; i<10; i++)
		{
			try {
				// main thread sleep
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(i);
			if (i==5) {
				autoSave = true;
			}
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e){
				
			}
			
			if (autoSave)
			{
				System.out.println("자동 저장되었어요.");
			}
		}
	}
	
}
