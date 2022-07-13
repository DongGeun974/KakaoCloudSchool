package _220713.com.computer;

public class Tab extends Computer implements Graphic{
	public Tab() {
		// TODO Auto-generated constructor stub
	}
	
	public Tab(String name, int cpu, int memory, int battary) {
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
