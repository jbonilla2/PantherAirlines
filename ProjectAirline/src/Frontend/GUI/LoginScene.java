package Frontend.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;	

public class LoginScene {

    //fields
    private static Scene scene;
    private static VBox loginLayout;
    private static Label loginLabel;
    private static Label pantherLabel;
    private static TextField usernameField;
    private static PasswordField passwordField;
    private static Button loginButton;
    private static Button registerButton;
    private static Button forgotpassButton;




	//initialization of objects
    public static  void initialize(){

        //loginLabel
    	loginLabel = new Label("Log in");
        loginLabel.setPadding((new Insets(0, 0, 30, 0)));
        loginLabel.setStyle("-fx-font-size: 24pt");


        //hermesLabel
        pantherLabel = new Label("Welcome to Panther Airlines");
        pantherLabel.setId("welcome");
        pantherLabel.setStyle("-fx-font-size: 24pt");

        //usernameField
        usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setMaxWidth(220);
        usernameField.setAlignment(Pos.CENTER);

        //passwordField
        passwordField = new PasswordField();
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setMaxWidth(220);
        passwordField.setPromptText("Password");

        //Login button
        loginButton=new Button("Login");
        loginButton.setMaxWidth(300);
        
        //Register button
        registerButton=new Button("Register");
        registerButton.setMaxWidth(300);

        
        //Forgot password button
        forgotpassButton=new Button("Forgot Password");
        forgotpassButton.setMaxWidth(300);
        
        //layout
        loginLayout = new VBox(10);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.getChildren().addAll(pantherLabel,loginLabel,usernameField,passwordField,loginButton,registerButton,forgotpassButton);

        //scene
        scene = new Scene(loginLayout,800,800);
        scene.getStylesheets().add("Frontend/GUI/style.css");



        System.out.println("login screen initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static VBox getLoginLayout() {
        return loginLayout;
    }

    public static Label getLoginLabel() {
        return loginLabel;
    }

    public static Label getPantherLabel() {
        return pantherLabel;
    }

    public static TextField getUsernameField() {
        return usernameField;
    }

    public static PasswordField getPasswordField() {
        return passwordField;
    }

    public static Button getLoginButton() {
        return loginButton;
    }


	public static Button getRegisterButton() {
		return registerButton;
	}

	public static Button getForgotpassButton() {
		return forgotpassButton;
	}

}
