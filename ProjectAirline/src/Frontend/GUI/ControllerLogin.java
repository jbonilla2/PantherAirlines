package Frontend.GUI;

import Frontend.SceneControl.*;

import java.util.ArrayList;

//import Application.DataTypes.Admin;
import Backend.User;
//import DataAccess.AdminData;
import javafx.scene.control.*;

public class ControllerLogin {

	public static Button registerButton = LoginScene.getRegisterButton();
	public static Button loginButton = LoginScene.getLoginButton();
	public static Button forgotButton = LoginScene.getRegisterButton();
	
	public static TextField usernameLog = LoginScene.getUsernameLog();
	public static TextField passwordLog = LoginScene.getPasswordLog();
    public static String username;
    public static String password;

   /// private static ArrayList<Customer> customer;
	
	
	//Register customer textfields
	public static TextField firstNameInput = new TextField();
	public static TextField lastNameInput = new TextField();
	public static TextField addressInput = new TextField();
	public static TextField cityInput = new TextField();
	public static TextField stateInput = new TextField();
	public static TextField zipInput = new TextField();
	public static TextField usernameInput = new TextField();
	public static TextField passwordInput = new TextField();
	public static TextField emailInput = new TextField();
	public static TextField ssnInput = new TextField();
	public static TextField secQuestionInput = new TextField();
	public static TextField anwQuestionInput = new TextField();
	
	//handle registration
	public static void handleRegisterButton() {
		
		firstNameInput.clear();
		lastNameInput.clear();
		
	}
	
	
	public static void handleLoginButton() {
		
		//username
        username = usernameLog.getText();

        //password
        password = passwordLog.getText();

		
		int ok = 0;

        if(isInputValid()) {
        	/*
            //verify the user credentials in database
            for(Customer customer: CustomerData.getCustomer()) {
                if (customer.getUsername() == username && customer.getPassword().equalsIgnoreCase(password)) {

                    //MainControl.showMenuScene(); //valid username and pass
                    System.out.println("login successful");
                    ok = 1;
                    break;
                }
            } */

            //wrong username or pass
           // if(ok == 0) {
                usernameLog.clear();
                passwordLog.clear();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Login failed");
                alert.setContentText("Invalid username or password");
                alert.initOwner(LoginScene.getWindow());
                alert.showAndWait();
           // }
        }
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
            alert.initOwner(LoginScene.getWindow());
            alert.showAndWait();
            return false;
        }
    }
	
	/*public void handleRegisterButton(TextField firstNameInput, TextField lastNameInput,TextField addressInput,
			TextField cityInput, TextField stateInput, TextField zipInput, TextField usernameInput, TextField passwordInput,
			TextField emailInput, TextField ssnInput, TextField secQuestionInput, TextField anwQuestionInput) {
		
		this.firstNameInput = firstNameInput;
		this.lastNameInput = lastNameInput;
		this.addressInput = addressInput;
		this.cityInput = cityInput;
		this.stateInput = stateInput;
		this.zipInput = zipInput;
		this.usernameInput = usernameInput;
		this.passwordInput = passwordInput;
		this.emailInput = emailInput;
		this.ssnInput = ssnInput;
		this.secQuestionInput = secQuestionInput;
		this.anwQuestionInput = anwQuestionInput;
		
		//Person newCustomer = new Person(firstNameInput.getText(), lastNameInput.getText(),addressInput.getText(),
		//		cityInput.getText(), stateInput.getText(), zipInput.getText(), usernameInput.getText(), passwordInput.getText(),
		//		emailInput.getText(), ssnInput.getText(), secQuestionInput.getText(), anwQuestionInput.getText());
		
		this.firstNameInput.clear();
		
		System.out.println("ehllo");
	} */

	public TextField getFirstNameInput() {
		return firstNameInput;
	}

	public void setFirstNameInput(TextField firstNameInput) {
		this.firstNameInput = firstNameInput;
	}

	public TextField getLastNameInput() {
		return lastNameInput;
	}

	public void setLastNameInput(TextField lastNameInput) {
		this.lastNameInput = lastNameInput;
	}

	public TextField getAddressInput() {
		return addressInput;
	}

	public void setAddressInput(TextField addressInput) {
		this.addressInput = addressInput;
	}

	public TextField getCityInput() {
		return cityInput;
	}

	public void setCityInput(TextField cityInput) {
		this.cityInput = cityInput;
	}

	public TextField getStateInput() {
		return stateInput;
	}

	public void setStateInput(TextField stateInput) {
		this.stateInput = stateInput;
	}

	public TextField getZipInput() {
		return zipInput;
	}

	public void setZipInput(TextField zipInput) {
		this.zipInput = zipInput;
	}

	public TextField getUsernameInput() {
		return usernameInput;
	}

	public void setUsernameInput(TextField usernameInput) {
		this.usernameInput = usernameInput;
	}

	public TextField getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(TextField passwordInput) {
		this.passwordInput = passwordInput;
	}

	public TextField getSecQuestionInput() {
		return secQuestionInput;
	}

	public void setSecQuestionInput(TextField secQuestionInput) {
		this.secQuestionInput = secQuestionInput;
	}

	public TextField getAnwQuestionInput() {
		return anwQuestionInput;
	}

	public void setAnwQuestionInput(TextField anwQuestionInput) {
		this.anwQuestionInput = anwQuestionInput;
	}

	public TextField getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(TextField emailInput) {
		this.emailInput = emailInput;
	}

	public TextField getSsnInput() {
		return ssnInput;
	}

	public void setSsnInput(TextField ssnInput) {
		this.ssnInput = ssnInput;
	}

	public static Button getRegisterButton() {
		return registerButton;
	}

	public static void setRegisterButton(Button registerButton) {
		ControllerLogin.registerButton = registerButton;
	}
	
	
	
}
