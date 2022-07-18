package _220718.exam01;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// server process

public class Exam01_DateServer {
	
	public static void main(String[] args) {
		try{
			ServerSocket serverSocket = new ServerSocket(5678);
			System.out.println("Date Server start");
			Socket socket = serverSocket.accept();		// blocking
			
			// success client connect
			// PrintWriter : string print stream
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			// current data
			Date date = new Date();
			pw.println(date.toLocaleString());		// 버퍼를 이용힌 스트림
			// 버퍼 안에 들어가 있는 데이터를 스트림을 통해 내보내는 시점
			// 1. 스트림이 강제로 종료될 경우
			// 2. 버퍼의 공간이 꽉 찰 경우
			// 3. flush() method 사용
			pw.flush();
			
			pw.close();		// case 1
			socket.close();
			serverSocket.close();
		}
		catch(Exception e ) {
			
		}
	}
	
}
