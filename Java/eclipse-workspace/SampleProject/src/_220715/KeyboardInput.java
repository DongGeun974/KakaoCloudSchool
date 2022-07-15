package _220715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {
	public static void main(String[] args) {
		System.out.println("키보드로 한 줄을 입력하세요");
		
		// 키보드(표준입력, System.in)를 통해 데이터를 1줄 입력받음
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(input);
	}
}
