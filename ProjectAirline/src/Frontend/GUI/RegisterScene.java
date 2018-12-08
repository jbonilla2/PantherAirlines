package Frontend.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RegisterScene {

	//fields
    private static Scene scene;
    private static VBox registerLayout;
    private static Label registerLabel;

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
    
    //button
    private static Button registerButton;
    private static Button backButton;
    
	//initialization of objects
    public static  void initialize(){

        //registerLabel
    	registerLabel = new Label("Join us!");
    	registerLabel.setPadding((new Insets(0, 0, 30, 0)));
    	registerLabel.setStyle("-fx-font-size: 24pt");

    	//firstName
    	firstName = new TextField();
    	firstName.setPromptText("First name");
    	firstName.setMaxWidth(220);
    	firstName.setAlignment(Pos.CENTER);

    	//lastName
    	lastName = new TextField();
    	lastName.setPromptText("Last name");
    	lastName.setMaxWidth(220);
    	lastName.setAlignment(Pos.CENTER);
    	
    	//address
    	address = new TextField();
    	address.setPromptText("Address");
    	address.setMaxWidth(220);
    	address.setAlignment(Pos.CENTER);
    	
    	//state
    	state = new TextField();
    	state.setPromptText("State");
    	state.setMaxWidth(220);
    	state.setAlignment(Pos.CENTER);
    	
    	//zip
    	zip = new TextField();
    	zip.setPromptText("Zip");
    	zip.setMaxWidth(220);
    	zip.setAlignment(Pos.CENTER);
    	
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
        
        //email
        email = new TextField();
        email.setPromptText("Email");
        email.setMaxWidth(220);
        email.setAlignment(Pos.CENTER);
      
        //ssn
        ssn = new TextField();
        ssn.setPromptText("SSN");
        ssn.setMaxWidth(220);
        ssn.setAlignment(Pos.CENTER);

        //security question
        secQ = new TextField();
        secQ.setPromptText("Input security question");
        secQ.setMaxWidth(220);
        secQ.setAlignment(Pos.CENTER);

        //security answer
        secA = new TextField();
        secA.setPromptText("Input security answer");
        secA.setMaxWidth(220);
        secA.setAlignment(Pos.CENTER);
        
        //Register button
        registerButton=new Button("Register");
        registerButton.setMaxWidth(120);

        //backbutton
        backButton=new Button("Back");
        backButton.setMaxWidth(120);

        
        //layout
        registerLayout = new VBox(10);
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.getChildren().addAll(registerLabel,firstName,lastName,address,state,zip,usernameField,passwordField,email,ssn,secQ,secA,registerButton,backButton);

        //scene
        scene = new Scene(registerLayout,800,800);
        scene.getStylesheets().add("Frontend/GUI/style.css");



        System.out.println("register screen initialized");
    }
    
    //getters
    
    
    public static Scene getScene() {
    	return scene;
    }
    
    public static VBox getRegisterLayout() {
    	return registerLayout;
    }
    
    public static Label getRegisterLabel() {
    	return registerLabel;
    }
    
    public static Button getRegisterButton() {
    	return registerButton;
    }
    
    public static TextField getFirstName() {
		return firstName;
	}

	public static TextField getLastName() {
		return lastName;
	}

	public static TextField getAddress() {
		return address;
	}

	public static TextField getState() {
		return state;
	}

	public static TextField getZip() {
		return zip;
	}

	public static TextField getUsernameField() {
		return usernameField;
	}

	public static PasswordField getPasswordField() {
		return passwordField;
	}

	public static TextField getEmail() {
		return email;
	}

	public static TextField getSsn() {
		return ssn;
	}

	public static TextField getSecQ() {
		return secQ;
	}

	public static TextField getSecA() {
		return secA;
	}

	public static Button getBackButton() {
		return backButton;
	}

}
