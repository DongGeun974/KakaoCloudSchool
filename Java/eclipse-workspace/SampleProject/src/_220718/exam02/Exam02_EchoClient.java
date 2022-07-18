package _220718.exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {

	TextArea textArea;
	Button connBtn;
	TextField idField, textField;
	
	Socket socket;
	InputStreamReader isr;
	BufferedReader br;
	PrintWriter pw;
	
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
			try {
				socket = new Socket("localhost",5678);
				// create IO
				isr = new InputStreamReader(socket.getInputStream());
				br = new BufferedReader(isr);
				pw = new PrintWriter(socket.getOutputStream());
				
				textArea.appendText("Succes Echo Server connect\n");
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		idField = new TextField();
		idField.setPrefSize(300, 40);
		
		textField = new TextField();
		textField.setPrefSize(200, 40);
		// 입력 상자에 입력 후 enter입력하면 이벤트 처리
		textField.setOnAction((e)->{
			String msg = idField.getText() + " : " + textField.getText();
			pw.println(msg);
			pw.flush();
		
			if (textField.getText().equals("/exit")) {
				textArea.appendText("Finish Echo Server connect\n");
				textField.setDisable(true);
			}else {
				try {
					String serverMsg = br.readLine();
					textArea.appendText(serverMsg+"\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			textField.clear();
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(connBtn);
		flowPane.getChildren().add(idField);
		flowPane.getChildren().add(textField);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch();
	}
}
