package _220714;

import javax.swing.JOptionPane;

class ThreadEx_04 extends Thread{
	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !isInterrupted()){
			System.out.println(--i);
		
//			for (long k = 0; k<2500000000L; k++);	// 시간지연
			
			
			try {
				Thread.sleep(4000);
				// Exception 생성
			}catch (Exception e) {
//				isInterrupted();		// false
//				interrupt();
				// TODO: handle exception
			}
			
			
		}
		
		System.out.println("카운트 종료");
	}
}

public class ThreadExample04 {
	public static void main(String[] args) {
		Thread t = new ThreadEx_04(); 
		
		t.start();
		
		String input = JOptionPane.showInputDialog("");
		System.out.println(input);
		
		t.interrupt();			// true
		// thread t의 interrupted 상태가 true
		System.out.println("thread의 상태값은 " + t.isInterrupted());
	}
}
