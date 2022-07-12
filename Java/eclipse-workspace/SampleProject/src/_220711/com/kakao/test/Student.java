package _220711.com.kakao.test;

//public class Student {
//	
////	field(변수)
//	String stdName;		// String : class, reference type, 문자열
//	String stdNum;		
//	int stdAge;
//	
//	static String univName;
//	
////	생성자
////	클래스 이름과 완전 일치
////	인스턴스 초기화 과정
////	default constructor
//	Student(){
//		
//	}
//	
////	method(함수)
//	public String getName() {
//		return this.stdName;
//	}
//	
//	public static String getUnivName() {
//		return univName;
//	}
//	
////	main + ctrl + space bar
//	public static void main(String[] args) {
//		Student std =  new Student();
//		// . operator
//		std.stdName = "홍길동";
//		std.univName = "한국대학교";
//		Student.univName = "미국대학교";
//		std.getName();
//		std.getUnivName();
//		Student.getUnivName();
//	}
//}

//public class Student{
//
//	public void getScore(String k) {
//		
//	}
//	
//	public void getScore(int k) {
//		
//	}
//	
//	static int a  = staticCall("1번");
//	int b = staticCall("2번");
//	
//	public static int staticCall(String msg) {
//		System.out.println(msg);
//		return 100;
//	}
//	
//	public Student() {
//		this.b = staticCall("3번");
//	}
//	
//	public static void main(String[] args) {
//		System.out.println("4번");
//		int c = staticCall("5번");
//		Student s = new Student();
//	}
//}


public class Student{
	
	// class 내부에서 보호되어야 하는 field
	private String stdName; 		// information hiding
	private String stdNum;
	
	public Student(){
		
	}
	
	// method는 행위를 하는 작업이기 때문에 특별한 이유가 없는 한
	// 외부에서 사용할 수 있도록 public으로 설정
	public String getStdName() {
		return this.stdName;
	}
	
	public void setStdName(String s) {
		this.stdName = s;
	}

	public String getStdNum() {
		return this.stdNum;
	}

	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
}

//class Main{
//	public static void main(String[] args) {
//		Student s = new Student();
////		s.stdName = "홍길동";
//	}
//}