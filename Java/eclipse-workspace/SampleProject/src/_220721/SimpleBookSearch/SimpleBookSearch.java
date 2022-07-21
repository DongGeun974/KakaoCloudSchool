// View

package _220721.SimpleBookSearch;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import _220721.SimpleBookSearch.service.BookService;
import _220721.SimpleBookSearch.vo.BookVO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SimpleBookSearch extends Application{
	TextArea textArea;
	Button findBtn, deleteBtn;
	TextField textField;
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// service instance
		BookService service = new BookService();
		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textArea = new TextArea();
		root.setCenter(textArea);
		
		findBtn = new Button("keyword로 검색");
		findBtn.setPrefSize(150, 40);
		findBtn.setOnAction((e)->{
			textArea.clear();
			ArrayList<BookVO> result =  service.bookSearchByKeyword(textArea.getText());
			for (int i = 0; i < result.size(); i++) {
				textArea.appendText(result.get(i).getBtitle() + "\n");
			}
		});
		
		deleteBtn = new Button("ISBN으로 삭제");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setOnAction((e)->{
			String isbn = textField.getText();
			System.out.println(isbn);
			String sql = "";
		});
		
		textField = new TextField();
		textField.setPrefSize(300, 40);
		
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10,10,10,10));
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(findBtn);
		flowPane.getChildren().add(textField);
		flowPane.getChildren().add(deleteBtn);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
