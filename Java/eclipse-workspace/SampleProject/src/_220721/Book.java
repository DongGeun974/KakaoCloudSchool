package _220721;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Book extends Application{

	TextArea textArea;
	Button findBtn, deleteBtn;
	TextField textField;
	
	private static BasicDataSource basicDS;
	
	
	public static BasicDataSource getBasicDS() {
		return basicDS;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		DataSource ds = getBasicDS();
		Connection con = ds.getConnection();
		con.setAutoCommit(false);

		
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textArea = new TextArea();
		root.setCenter(textArea);
		
		findBtn = new Button("keyword로 검색");
		findBtn.setPrefSize(150, 40);
		findBtn.setOnAction((e)->{
			textArea.clear();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String title = textField.getText();
			System.out.println(title);
			String sql = "select btitle, bisbn from book where btitle like ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+title+"%");
				rs = pstmt.executeQuery();
				con.commit();
				
				while(rs.next()) {
					textArea.appendText(rs.getString("btitle") + "\n" + rs.getString("bisbn") + "\n");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	
	static {
		try {
			basicDS = new BasicDataSource();
			
			Properties properties = new Properties();
			InputStream is = new FileInputStream("resources/db.properties");
			properties.load(is);
			
			basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS"));
			basicDS.setUrl(properties.getProperty("JDBC_URL"));
			basicDS.setUsername(properties.getProperty("DB_USER"));
			basicDS.setPassword(properties.getProperty("DB_PASSWORD"));
			
			basicDS.setInitialSize(10);
			basicDS.setMaxTotal(10);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
