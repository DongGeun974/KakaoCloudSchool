package _220715;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// JavaFX
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyNotepad extends Application{
	
	TextArea textarea;
	Button saveBtn, openBtn;
	File file;
	
	private void printMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg+"\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textarea = new TextArea();
		root.setCenter(textarea);
		
		openBtn = new Button("파일 열기");
		openBtn.setPrefSize(150, 40);
		openBtn.setOnAction(e ->{
			textarea.clear();
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("오픈할 파일을 선택해주세여");
			file = fileChooser.showOpenDialog(primaryStage);
			
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";
				while((line = br.readLine()) != null) {
					printMsg(line);
				}
				br.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch (IOException e2) {
				// TODO: handle exception
			}
		});
//		openBtn.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				System.out.println("click");
//			}
//		});
		
		saveBtn = new Button("파일 저장");
		saveBtn.setPrefSize(150, 40);
		saveBtn.setOnAction(e->{
			String text = textarea.getText();
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(text);
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		
		flowPane.getChildren().add(openBtn);
		flowPane.getChildren().add(saveBtn);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("memo");
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
