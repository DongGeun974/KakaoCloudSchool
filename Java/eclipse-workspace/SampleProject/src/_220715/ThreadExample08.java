package _220715;

class ThreadEx_08_1 extends Thread{
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// invoke interrupt
				System.out.println("invoked interrupt");
			}
			gc();
			System.out.println("메모리 청소 완료, 현재 메모리 사용 가능 용량 : " + getFreeMemory());
		}
	}
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) {
			usedMemory = 0;
		}
	}
	
	public static int getMaxMemory() {
		return MAX_MEMORY;
	}
	

	public int getFreeMemory() {
		return MAX_MEMORY - usedMemory;
	}
	
	public int getUsedMemory() {
		return usedMemory;
	}
	
}

public class ThreadExample08 {
	public static void main(String[] args) {
		ThreadEx_08_1 t= new ThreadEx_08_1();
		
		t.setDaemon(true);
		t.start();
		
		int requiredMemory = 0;
		
		for(int i = 0; i<20; i++) {
			requiredMemory = (int)(Math.random()*10) * 20;			// 0.0 =< x < 1.0
			
			// 필요한 memory가 사용할 수 있는 양보다 크거나
			// 현재 전체 메모리양의 60% 이상 사용하고 있을 때
			// GC
			if (requiredMemory> t.getFreeMemory() || t.getFreeMemory() < t.getMaxMemory() * 0.4) {
				t.interrupt();		// gc실행이 끝날 때까지 기다리지 않음
				try {
					t.join(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			t.usedMemory += requiredMemory;
			System.out.println(" 사용된 용량 : " + t.usedMemory);

		}
		
	}
}
