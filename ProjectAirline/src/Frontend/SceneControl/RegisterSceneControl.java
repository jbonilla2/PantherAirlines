package Frontend.SceneControl;

import Backend.User;
import Frontend.GUI.LoginScene;
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
            
            User newuser = new User(Integer.parseInt(ssnStr), firstStr, lastStr, addressStr, Integer.parseInt(zipStr), stateStr, username, password, emailStr, secqStr, secqStr);
        	
            UserData.insertUser(newuser); //add customer to database

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Customer added!");
            alert.showAndWait();

            System.out.println("new customer added");
            
            handle_registerButton();
        });
    	
    }
	
  //handle login button
    public static void handle_registerButton(){
        MainControl.showLoginScene();
    	
    	/*
    	int ok = 0;

        if(isInputValid()) {
        	
        	MainControl.showLoginScene(); //valid username and pass
            System.out.println("registration successful");
            ok = 1;
            
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
           // }
        } */
    }
 
    //method to verify the user input
    public static boolean isInputValid(){
        String error = "";

        if(username.isEmpty())
            error+="Insert username!\n";
        else 
        	
        	/*try{
            Integer.parseInt(username);
        }
        
        //Delete
        catch(NumberFormatException e){
            error +="Invalid username!\n";
        } */

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

    
}
