package _220713.com.computer;

public class ComputerTest {
	public static void main(String[] args) {
		Computer arrays [] = new Computer[4];
		arrays[0] = new Laptop("Lap1", 2, 1024, 2000);
		arrays[1] = new Laptop("Lap2", 3, 1024, 2000);
		arrays[2] = new Tab("Tap1", 2, 1024, 2000);
		arrays[3] = new Tab("Tap2", 3, 2048, 2000);
		
		for(Computer c : arrays) {
			System.out.println(c);
		}
		
		for(Computer c : arrays) {
			System.out.println(c.toString() + " " + String.format("%.2f",((Graphic)c).rendering(100)));
		}
	}
}
