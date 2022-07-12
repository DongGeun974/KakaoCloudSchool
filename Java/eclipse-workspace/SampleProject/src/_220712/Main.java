package _220712;

public class Main {
	
	public static void main(String[] args) {
		InstanceTest test;
		System.out.println("3번 출력");
		int k = InstanceTest.myCall("4번 출력");
		test = new InstanceTest();
		test.printMsg("5번 출력");
	}
}
