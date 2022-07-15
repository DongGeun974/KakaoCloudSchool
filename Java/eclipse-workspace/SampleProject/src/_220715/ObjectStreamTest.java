package _220715;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectStreamTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "hong");
		map.put("2", "kim");
		map.put("3", "kang");
		
		File file = new File("C:/Users/user/Desktop/ww.txt");
		FileOutputStream fos;
		
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(map);
			
			oos.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
