package _220713.shape;

public class Rectangle extends Shape implements Movable{
	private int width;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public Rectangle(int width, int x, int y) {
		// TODO Auto-generated constructor stub
		super(new Point(x,y));
		this.width = width;
	}
	
	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		setPoint(new Point(x+2,y+2));
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.width;
	}

	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return this.width * 4;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rectangle\t" + this.width+"\t" + getPoint().getX() +"\t" + getPoint().getY() +"\t" + getArea()  +"\t" + getCircumference(); 
	}
	
}
