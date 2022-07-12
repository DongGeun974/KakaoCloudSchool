package _220712;

class Superclass{
	// static method
	static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	// field
	int a = staticCall("1번입니다.");
	static int b = staticCall("2번입니다.");
	
	// constructor
	public Superclass() {
		staticCall("3번입니다.");
	}
	
	public Superclass(int i) {
		this();
		staticCall("4번입니다.");
	}
	
	// method
	public void myFunc() {
		System.out.println("5번입니다.");
	}
}

// 실행 할 때, 상위 정보부터 method area에 적재
public class InheritanceTest extends Superclass{
	// field
	int c = staticCall("6번입니다.");
	static int d = staticCall("7번입니다.");
	
	// constructor
	public InheritanceTest() {
		super(100);
		staticCall("8번입니다.");
		super.myFunc();
	}
	
	// method
	@Override
	public void myFunc() {
			System.out.println("9번입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("10번입니다.");
		Superclass obj = new InheritanceTest();
		System.out.println();
		obj.myFunc();		
		// 객체에 대한 type이 상위 타입이라 할지라도, 만약 overriding된 method가 존재하면
		// method는 overriding된 method 사용
		// 동적 바인딩(dynamic binding)
	}
}

// 7 10 2 3 4 8 5
// 2번은 extends 때문에
// 1번은 superclass 생성자 호출 전 인스턴스를 만들기 때문에
// 6번은 생성자 전에 변수 먼저 할당

// 객체가 최상위부터 생성
// 2 7 10 1 3 4 6 8 5