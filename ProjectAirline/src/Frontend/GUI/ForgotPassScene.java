package Frontend.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ForgotPassScene {

	private static Stage dialogStage;
	private static Scene scene;
    private static VBox layout;
    private static Label usernameLabel;
    private static TextField usernameField;
    private static TextField secaField; //user inputs security answer
    
    private static Button find; //submit username
    private static Button submit; //submit security answer
    private static Button back; //return to login
    
    //initialize
    public static void initialize(){
    
    	usernameLabel = new Label("Enter your username");
    	usernameLabel.setAlignment(Pos.CENTER);
    	
    	//username text field
    	usernameField = new TextField();
    	usernameField.setPromptText("Username");
    	usernameField.setMaxWidth(220);
    	usernameField.setAlignment(Pos.CENTER);
    	
    	secaField = new TextField();
    	secaField.setPromptText("Security answer");
    	secaField.setMaxWidth(200);
    	secaField.setAlignment(Pos.CENTER);
    	
    	find = new Button("Find SecQ");
    	find.setMaxWidth(300);
    	find.setAlignment(Pos.CENTER);
    	
    	submit = new Button("Submit");
    	submit.setMaxWidth(200);
    	submit.setAlignment(Pos.CENTER);
    	
    	back = new Button("Close");
    	back.setMaxWidth(200);
    	back.setAlignment(Pos.CENTER);
    	
    	layout = new VBox(10);
    	layout.setAlignment(Pos.CENTER);
    	layout.getChildren().addAll(usernameLabel,usernameField,find,secaField,submit,back);
    	 
    	//scene
    	scene = new Scene(layout,500,600);
    	scene.getStylesheets().add("Frontend/GUI/style.css");
    	
    	dialogStage = new Stage();
    	dialogStage.setScene(scene);
    	
    	System.out.println("forgot pass screen initialized");

    }
	
	
	public static Button getBack() {
		return back;
	}


	public static Button getFind() {
		return find;
	}
	public static Label getUsernameLabel() {
		return usernameLabel;
	}
	public static TextField getUsernameField() {
		return usernameField;
	}
	public static Scene getScene() {
		return scene;
	}
	public static VBox getLayout() {
		return layout;
	}
	public static TextField getSecaField() {
		return secaField;
	}
	public static Button getSubmit() {
		return submit;
	}


	public static Stage getDialogStage() {
		return dialogStage;
	}
    
	
}
