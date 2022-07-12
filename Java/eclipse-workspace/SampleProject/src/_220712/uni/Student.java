package _220712.uni;

class Student extends Human{
	private String number;
	private String major;
	
	public Student() {
		
	}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.major=major;
		this.number=number;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String printInformation() {
		return super.printInformation()+this.number+"\t"+this.major;
	}
}