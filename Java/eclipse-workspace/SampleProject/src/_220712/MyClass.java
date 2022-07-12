package _220712;

public class MyClass {
	int aaa;
	static int bbb = staticCall();

	public MyClass() {

	}
	
	// static block
	static {
		// main이 실행되지 직전에 다른 library같은 것들을 loading할 필요가 있을 때
		// 사전 작업
		System.out.println("static block");
	}
	
	static int staticCall() {
		System.out.println("호줄되었어요");
		return 100;
	}
	
	public static void main(String[] args) {
		System.out.println("main 호출");
	}
}
