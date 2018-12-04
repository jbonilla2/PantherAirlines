package Frontend.SceneControl;

import Backend.User;
import Frontend.GUI.ForgotPassScene;
import databaseAccess.UserData;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ForgotPassControl {

    private static TextField usernameField;
    private static TextField secqLabel; //updates to user's security question
    private static TextField secaField; //user inputs security answer
    private static Button find;
    private static Button submit; //submit security answer
    private static Button back;
    
    //initialize
    public static void initialize(){
    	
    	usernameField = ForgotPassScene.getUsernameField();
    	
    	//security question should populate after username is input

        //security answer field
        secaField = ForgotPassScene.getSecaField();
      

        //registerButton
        find = ForgotPassScene.getFind();
        find.setOnAction(e -> handle_findButton());
        
        //submit button returns password
        submit = ForgotPassScene.getSubmit();
        submit.setOnAction(e -> handle_submitButton());
        
        back = ForgotPassScene.getBack();
        back.setOnAction(e -> handle_backButton());

    }
    
    public static void handle_backButton() {
    	ForgotPassScene.getDialogStage().close();
    }
    
    public static void handle_submitButton() {
    	for(User user: UserData.getUsers()) {
        	if (user.getSecurityA().equals(secaField.getText())) {

        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Password Recovery");
                alert.setContentText("Your password: " + user.getPassword());
                alert.initOwner(MainControl.getWindow());
                alert.showAndWait();
        		
                System.out.println("return security answer successful");
        		break;
        	}
        }
    }
    
    public static void handle_findButton() {
    	
    	for(User user: UserData.getUsers()) {
        	if (user.getUsername().equals(usernameField.getText())) {
        		String secQ = user.getSecurityQ();
        		
        		Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Password Recovery");
                alert.setContentText("Your security question: " + secQ);
                alert.initOwner(MainControl.getWindow());
                alert.showAndWait();
        		
        		
        		System.out.println("return security answer successful " + secQ);
        		break;
        	}
        }
    }
    	

}
