package _220712.planetest;

public class Cargoplane extends Plane{
	public Cargoplane() {
		// TODO Auto-generated constructor stub
	}
	
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance/10*50));
	}
}
