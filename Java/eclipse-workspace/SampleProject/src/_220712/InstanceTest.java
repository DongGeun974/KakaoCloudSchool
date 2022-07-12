package _220712;

public class InstanceTest {
	
	// field
	int a = myCall("1번 출력");
	// method area에 메모리 할당
	static int b = myCall("2번 출력");
	
	// constructor
	public InstanceTest() {
		
	}
	
	// method
	public static int myCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	public void printMsg(String msg) {
		int a = 100;
		System.out.println(msg);
	}

}
