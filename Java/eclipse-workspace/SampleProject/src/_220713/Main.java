package _220713;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {

	public static void main(String[] args) {
//		String str1 = "hello";
//		String str2 = "hello";
//		String str3 = new String("hello");
//		
//		System.out.println(str1 == str2);
//		System.out.println(str1 == str3);
//		
//		System.out.println(str1.equals(str3));
		
		// 배열과 비슷, 동적 사이즈 변경 가능
		// 저장은 무조건 객체
		// 다양한 형태의 객체 저장
		List list = new ArrayList<>();
		list.add("Hello");
		list.add("홍길동");
		list.add(100);
		list.add(new Integer(100));
		
		// List에 같은 데이터 타입을 이용하는 경우가 대부분
		List<String> list1 = new ArrayList<String>();
		list1.add("hi");
		list1.add("22");
//		list1.add(22);
		
		// Map
		Map map = new HashMap<>();
		map.put("1", "hong");
		map.put("2", "hello");
		
		// API Reference를 참조해서 각 collection의 이용방법을 찾아서 써봐요
		
	}
}
