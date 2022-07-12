package _220712;

public abstract class UpperClass {

	// field
	String name;
	int age;
	
	// method
	public abstract void printAll();		// abstract methods
}

class subClass extends UpperClass{
	@Override
	public void printAll() {
		
	}
}
