package _220718.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam02_EchoServer {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket = null;		// blocking
		PrintWriter pw = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try{
			serverSocket = new ServerSocket(5678);
			System.out.println("Echo Server start");
			socket = serverSocket.accept();		// blocking
			
			// success client connect
			// PrintWriter : string print stream
			pw = new PrintWriter(socket.getOutputStream());
			isr = new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isr);
			
			String msg = "";
			
			while(true) {
				msg = br.readLine();
				if (msg.equals("/exit") || msg==null) {
					break;
				}
				pw.println(msg);
				pw.flush();
			}
			
		}
		catch(Exception e ) {
			
		}finally {
			try {
				if(br!= null)br.close();
				if(pw!= null)pw.close();
				if(isr!= null)isr.close();
				if(socket!=null)socket.close();
				if(serverSocket!=null)serverSocket.close();
				System.out.println("서버 종료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
