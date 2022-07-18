package _220718.exam01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application{
	
	TextArea textArea;
	Button connBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textArea = new TextArea();
		root.setCenter(textArea);
		
		connBtn = new Button("Date server connect");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction((e)->{
			textArea.clear();
			
			// try connect server
			try {
				Socket socket = new Socket("localhost",5678);
				
				// success connect server
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				
				// blocking method
				// 읽을 수 있는 것이 있을 때까지 대기
				// 서버보다 먼저 실행되더라도 대기
				String msg = br.readLine();
				textArea.appendText(msg+"\n");
				
				// release resource
				br.close();
				isr.close();
				socket.close();
				textArea.appendText("서버와의 연결이 종료");
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
