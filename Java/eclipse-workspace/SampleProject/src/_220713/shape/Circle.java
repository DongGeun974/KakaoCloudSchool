package _220713.shape;

public class Circle extends Shape implements Movable{

	private int radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Circle(int radius, int x, int y) {
		// TODO Auto-generated constructor stub
		super(new Point(x,y));
		this.radius = radius;
	}
	
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		setPoint(new Point(x+1,y+1));
		
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius *radius * 3.14;
	}

	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return radius * 3.14;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle\t\t" + this.radius +"\t" + getPoint().getX() +"\t" + getPoint().getY() +"\t" + getArea()  +"\t" + getCircumference(); 
	}

}
