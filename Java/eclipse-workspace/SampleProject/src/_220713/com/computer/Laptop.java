package _220713.com.computer;

public class Laptop extends Computer implements Graphic{
	public Laptop() {
		// TODO Auto-generated constructor stub
	}
	
	public Laptop(String name, int cpu, int memory,int battary) {
		super(name, cpu, memory, battary);
	}

	@Override
	public double rendering(int size) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void operate(int time) {
		// TODO Auto-generated method stub
		
	}
}
