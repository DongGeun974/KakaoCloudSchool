package _220712.planetest;

public class Airplane extends Plane{

	public Airplane() {
		// TODO Auto-generated constructor stub
	}
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance/10*30));
	}
	
}
