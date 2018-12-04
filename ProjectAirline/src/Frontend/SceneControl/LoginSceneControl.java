package Frontend.SceneControl;

import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginSceneControl {

    //fields
    //Buttons
	private static Button loginButton;
	private static Button registerButton;
	private static Button forgotpassButton;
    
    private static TextField usernameField;
    private static TextField passwordField;
    private static String username;
    private static String password;


    //initialize
    public static void initialize(){
        //username field
        usernameField = LoginScene.getUsernameField();

        //password field
        passwordField = LoginScene.getPasswordField();

        //registerButton
        registerButton = LoginScene.getRegisterButton();
        registerButton.setOnAction(e -> handle_registerButton());
        
        //loginButton
        loginButton = LoginScene.getLoginButton();
        //loginButton.setDefaultButton(true);
        loginButton.setOnAction(e->{
        	//username
            username = usernameField.getText();

            //password
            password = passwordField.getText();

            handle_loginButton();
        });
      
        //registerButton
        forgotpassButton = LoginScene.getRegisterButton();
        forgotpassButton.setOnAction(f -> handle_forgotpassButton());
        
    }

    //handle register button
    private static void handle_registerButton() {
		MainControl.showRegisterScene(); //Switch to register screen
    }

  //handle forgot password button
    private static void handle_forgotpassButton() {
    	//verify the username in database to have popup appear
        for(User user: UserData.getUsers()) {
        	if (user.getUsername().equals(username)) {

        		MainControl.showMenuScene(); //valid username and pass
        		System.out.println("login successful");
        		break;
        	}
        }
	}
    
	//handle login button
    public static void handle_loginButton(){
        int ok = 0;

        if(isInputValid()) {
        	//verify the user credentials in database
        	for(User user: UserData.getUsers()) {
        		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

        			MainControl.showMenuScene(); //valid username and pass
        			System.out.println("login successful");
        			ok = 1;
        		break;
        
        		}
    		}	
        }
        //wrong username or pass
        if(ok == 0) {

        	usernameField.clear();
        	passwordField.clear();

        	Alert alert = new Alert(Alert.AlertType.WARNING);
        	alert.setHeaderText("Login failed");
        	alert.setContentText("Invalid username or password");
        	alert.initOwner(MainControl.getWindow());
        	alert.showAndWait();
        }
    }


    //method to verify the user input
    public static boolean isInputValid(){
        String error = "";

        if(username.isEmpty())
            error+="Insert username!\n";
        if(password.isEmpty())
            error += "Insert password!\n";
        if(error=="")
            return true;
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.initOwner(MainControl.getWindow());
            alert.showAndWait();
            return false;
        }
    }
    
    public static void main(String[] args) {
    	
    }

}
