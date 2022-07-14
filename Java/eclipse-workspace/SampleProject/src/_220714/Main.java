package _220714;

public class Main {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		try {
			Object obj = null;
			System.out.println(obj.toString());
			int result = 10 / 0;		// 오류 발생
		}catch(NullPointerException e){
			System.out.println("1 오류 발생");
		}catch(Exception  e){
			// 최상위 객체
			System.out.println("2 오류 발생");
		}finally {
			// 무조건 실행
			
		}
		
		System.out.println("프로그램 종료");
	}
}
