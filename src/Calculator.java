/**
 * 
 * @author Maytal Twig
 * @mtwig95@gmail.com
 * @date 05/12/2021 
 * Main class for javaFX
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Calculator extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Calculator.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("Calculator"); 
		stage.setScene(scene); 
		stage.setResizable(false);
		stage.show();
	} 
	
	public static void main(String[] args) { 
		launch(args); 
	} 
} 