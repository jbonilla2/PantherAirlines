package Frontend.SceneControl;

import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginScene {
	
	//fields
    public static Stage window = new Stage();
    
	
	//Register customer textfields
	private static TextField firstNameInput = new TextField();
	private static TextField lastNameInput = new TextField();
	private static TextField addressInput = new TextField();
	private static TextField cityInput = new TextField();
	private static TextField stateInput = new TextField();
	private static TextField zipInput = new TextField();
	private static TextField usernameInput = new TextField();
	private static TextField passwordInput = new TextField();
	private static TextField emailInput = new TextField();
	private static TextField ssnInput = new TextField();
	private static TextField secQuestionInput = new TextField();
	private static TextField anwQuestionInput = new TextField();
		
	private static Button registerButton;
	private static Button loginButton;
	private static Button forgotButton;
		
	private static TextField usernameLog = new TextField();
	private static PasswordField passwordLog = new PasswordField();
	
	
	public static TextField getFirstNameInput() {
		return firstNameInput;
	}
	public static void setFirstNameInput(TextField firstNameInput) {
		LoginScene.firstNameInput = firstNameInput;
	}
	public static TextField getLastNameInput() {
		return lastNameInput;
	}
	public static void setLastNameInput(TextField lastNameInput) {
		LoginScene.lastNameInput = lastNameInput;
	}
	public static TextField getAddressInput() {
		return addressInput;
	}
	public static void setAddressInput(TextField addressInput) {
		LoginScene.addressInput = addressInput;
	}
	public static TextField getCityInput() {
		return cityInput;
	}
	public static void setCityInput(TextField cityInput) {
		LoginScene.cityInput = cityInput;
	}
	public static TextField getStateInput() {
		return stateInput;
	}
	public static void setStateInput(TextField stateInput) {
		LoginScene.stateInput = stateInput;
	}
	public static TextField getZipInput() {
		return zipInput;
	}
	public static void setZipInput(TextField zipInput) {
		LoginScene.zipInput = zipInput;
	}
	public static TextField getUsernameInput() {
		return usernameInput;
	}
	public static void setUsernameInput(TextField usernameInput) {
		LoginScene.usernameInput = usernameInput;
	}
	public static TextField getPasswordInput() {
		return passwordInput;
	}
	public static void setPasswordInput(TextField passwordInput) {
		LoginScene.passwordInput = passwordInput;
	}
	public static TextField getEmailInput() {
		return emailInput;
	}
	public static void setEmailInput(TextField emailInput) {
		LoginScene.emailInput = emailInput;
	}
	public static TextField getSsnInput() {
		return ssnInput;
	}
	public static void setSsnInput(TextField ssnInput) {
		LoginScene.ssnInput = ssnInput;
	}
	public static TextField getSecQuestionInput() {
		return secQuestionInput;
	}
	public static void setSecQuestionInput(TextField secQuestionInput) {
		LoginScene.secQuestionInput = secQuestionInput;
	}
	public static TextField getAnwQuestionInput() {
		return anwQuestionInput;
	}
	public static void setAnwQuestionInput(TextField anwQuestionInput) {
		LoginScene.anwQuestionInput = anwQuestionInput;
	}
	public static Button getRegisterButton() {
		return registerButton;
	}
	public static void setRegisterButton(Button registerButton) {
		LoginScene.registerButton = registerButton;
	}
	public static TextField getUsernameLog() {
		return usernameLog;
	}
	public static void setUsernameLog(TextField usernameLog) {
		LoginScene.usernameLog = usernameLog;
	}
	public static PasswordField getPasswordLog() {
		return passwordLog;
	}
	public static void setPasswordLog(PasswordField passwordLog) {
		LoginScene.passwordLog = passwordLog;
	}
	
	public static Stage getWindow() {
		return window;
	}
	public static void setWindow(Stage window) {
		LoginScene.window = window;
	}
	public static Button getLoginButton() {
		return loginButton;
	}
	public static void setLoginButton(Button loginButton) {
		LoginScene.loginButton = loginButton;
	}
	public static Button getForgotButton() {
		return forgotButton;
	}
	public static void setForgotButton(Button forgotButton) {
		LoginScene.forgotButton = forgotButton;
	}
		
}
