package _220712;


class Person extends Object{
//	public Person(String name) {
//		this.name = name;
//	}
	String name;			// 이름
	String mobile;			// 전화번호
	
	public void printAll() {
		System.out.println(" 모두 출력");
	}
}

// tightly coupled
class InheritanceStudent extends Person{
	String dept;			// 학과

	// default constructor
	public InheritanceStudent() {
		this("홍길동");
	}
	
	public InheritanceStudent(String name) {
		this.name = name;
	}
	
	public void printAll() {
		System.out.println("오버라이딩");
	}
	
	public static void main(String[] args) {
		InheritanceStudent s = new InheritanceStudent();
//		Person s = new Student();
//		Object s = new Student();
		// is-a relationship
		// subclass is a superclass
		
		s.printAll();
	}
}
