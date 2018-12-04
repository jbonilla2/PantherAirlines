package Frontend.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPassScene {

	private static Scene scene;
    private static VBox layout;
    private static Label usernameLabel;
    private static Label secqLabel; //updates to user's security question
    private static TextField usernameField;
    private static TextField secaField; //user inputs security answer
    
    //initialize
    public static void initialize(){
    
    	usernameLabel = new Label("Enter your username");
    	usernameLabel.setAlignment(Pos.CENTER);
    	
    	//username text field
    	usernameField = new TextField();
    	usernameField.setPromptText("Username");
    	usernameField.setMaxWidth(220);
    	usernameField.setAlignment(Pos.CENTER);
    	
    	
    }
    
	
}
