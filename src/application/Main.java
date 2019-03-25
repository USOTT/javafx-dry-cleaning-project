package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("cleaningorders1.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	  public static void main(String[] args) {
	        launch(args);
	        try {
	    		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/georgetowndrycleaner", "root", "saruul0201");
	    		Statement myStmt = (Statement) myConn.createStatement();
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    	}
	    }
}
