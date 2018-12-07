package Frontend.SceneControl;

import java.sql.Connection;
import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import databaseAccess.DBconnect;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainControl {

    //fields
    public static Stage window = new Stage();

    //register scene
    public static void showRegisterScene() {
    	//connect to database
    	Connection conn = DBconnect.connect();

    	//initialization of scene
    	RegisterScene.initialize();
    	
    	//initialization of controller
    	RegisterSceneControl.initialize();
    	
    	//set scene
    	window.setScene(RegisterScene.getScene());
    	window.setTitle("Panther Airlines - Register New");
    	window.centerOnScreen();
    }

    //forgot password scene
    public static void showForgotPassScene() {
    	//connect to database
    	//Connection conn = DBconnect.connect();

    	//initialization of scene
    	ForgotPassScene.initialize();
    	
    	//initialization of controller
    	ForgotPassControl.initialize();
    	
    	//set scene
    	ForgotPassScene.getDialogStage().initOwner(window);
        ForgotPassScene.getDialogStage().setTitle("Panther Airlines - Forgot Password");
        ForgotPassScene.getDialogStage().showAndWait();

    }
    
    //menu scene
    public static void showMenuScene(){
        //initialization of scene
        MenuScene.initialize();

        //initialization of controller
        MenuSceneControl.initialize();

        //set scene
        window.setScene(MenuScene.getScene());
        window.setTitle("Panther Airlines");
        window.centerOnScreen();

    }


    //login scene
    public static void showLoginScene() {
        //connect to database
    	Connection conn = DBconnect.connect();

        //initialization of scene
        LoginScene.initialize();

        //initialization of actions
        LoginSceneControl.initialize();
        
        //set scene
        window.setScene(LoginScene.getScene());
        window.setTitle("Panther Airlines");      

        window.show();
        window.centerOnScreen();
    }


    //view bookings scene
    public static void showViewBookingScene(){
        //initialization of scene
        ViewBookingScene.initialize();

        //initialization of actions
        ViewBookingSceneControl.initialize();

        //set scene
        window.setScene(ViewBookingScene.getScene());
        window.setTitle("Panther Airlines - Bookings");
        window.centerOnScreen();
    }

    //view flights scene
    public static void showViewFlightsScene(){
        //initialization of scene
        try {
			ViewFlightsScene.initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //initialization of controller
        ViewFlightSceneControl.initialize();

        //set scene
        window.setScene(ViewFlightsScene.getScene());
        window.setTitle("Panther Airlines - Flights");
        window.centerOnScreen();
    }

    //flight edit dialog
    public static void showFlightEditScene(){
        //initialization of scene
        FlightsEditScene.initialize();

        //initialization of controller
        FlightEditSceneControl.initialize();

        FlightsEditScene.getDialogStage().initOwner(window);
        FlightsEditScene.getDialogStage().setTitle("Flight menu");
        FlightsEditScene.getDialogStage().showAndWait();

    }

    //getters
    public static Stage getWindow() {
        return window;
    }

}
