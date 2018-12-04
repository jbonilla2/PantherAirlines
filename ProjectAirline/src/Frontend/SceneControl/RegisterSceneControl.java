package Frontend.SceneControl;

import Frontend.SceneControl.MainControl;
import Backend.*;
import Frontend.GUI.RegisterScene;
import databaseAccess.UserData;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterSceneControl {

	//fields
	
	//text fields 
    private static TextField firstName;
    private static TextField lastName;
    private static TextField address;
    private static TextField state;
    private static TextField zip;
    private static TextField usernameField;
    private static PasswordField passwordField;
    private static TextField email;
    private static TextField ssn;
    private static TextField secQ;
    private static TextField secA;
    
    //string fields
    private static String firstStr;
    private static String lastStr;
    private static String addressStr;
    private static String stateStr;
    private static String zipStr;
    private static String username;
    private static String password;
    private static String emailStr;
    private static String ssnStr;
    private static String secqStr;
    private static String secaStr;
    
    //button
    private static Button registerButton;
    private static Button backButton;
	
	//initialize
    public static void initialize() {
    
    	//get text field
    	firstName = RegisterScene.getFirstName();
    	lastName = RegisterScene.getLastName();
    	address = RegisterScene.getAddress();
    	state = RegisterScene.getState();
    	zip = RegisterScene.getZip();
    	usernameField = RegisterScene.getUsernameField();
        passwordField = RegisterScene.getPasswordField();
        email = RegisterScene.getEmail();
        ssn = RegisterScene.getSsn();
        secQ = RegisterScene.getSecQ();
        secA = RegisterScene.getSecA();
        
      //registerButton
        registerButton = RegisterScene.getRegisterButton();
        registerButton.setDefaultButton(true);
        
        //Action on registerButton
        registerButton.setOnAction(e->{
        
        	//Get text
            firstStr = firstName.getText();
            lastStr = lastName.getText();
            addressStr = address.getText();
            stateStr = state.getText();
            zipStr = zip.getText();
            username = usernameField.getText();
            password = passwordField.getText();
            emailStr = email.getText();
            ssnStr = ssn.getText();
            secqStr = secQ.getText();
            secaStr = secA.getText();
            
            User newuser = new User(Integer.parseInt(ssnStr), firstStr, lastStr, addressStr, Integer.parseInt(zipStr), stateStr, username, password, emailStr, secqStr, secaStr);
        	
            UserData.insertUser(newuser); //add customer to database
            
            handle_registerButton();
        });
        
        backButton = RegisterScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());
    	
    }
	
    //handle login button
    public static void handle_registerButton(){
        
        int ok = 0;
        
        for (User user : UserData.getUsers()) {
        	if (user.getUsername() == username) {
        		
        		usernameField.clear();
                passwordField.clear();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Login failed");
                alert.setContentText("Invalid username or password");
                alert.initOwner(MainControl.getWindow());
                alert.showAndWait();
                ok = 1;
                break;
        		
        	}
        }	
        if(ok == 0) {
                
        	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        	alert.initOwner(MainControl.getWindow());
        	alert.setContentText("Customer added!");
        	alert.showAndWait();

        	System.out.println("new customer added");
        	
        	MainControl.showLoginScene();
                
        }
        
   }
 
    public static void handle_backButton() {
    	MainControl.showLoginScene();
    }

    
}
