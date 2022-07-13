package _220713.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6,6,7));
		list.add(new Circle(7,8,3));
		
		for(Object c:list) {
			System.out.println(c);
			((Movable)c).move(((Shape)c).getPoint().getX() + 10, ((Shape)c).getPoint().getY() + 10);
		}
		System.out.println("mo...ve.... m...ov...e");
		for(Object c:list) {
			System.out.println(c);
		}
	}
}
