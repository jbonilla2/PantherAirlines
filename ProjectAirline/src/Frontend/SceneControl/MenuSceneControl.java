package Frontend.SceneControl;

import Frontend.GUI.MenuScene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MenuSceneControl {

    //fields
    private static Button bookingsB, flightsB, exitB, logoutB;

    //initialization of fields
    public static void initialize(){
        //bookingsB
        bookingsB = MenuScene.getBookingsB();
        bookingsB.setOnAction(e -> handle_bookingsB());

        //flightsB
        flightsB = MenuScene.getFlightsB();
        flightsB.setOnAction(e -> handle_flightsB());
        
        //exitB
        exitB = MenuScene.getExitB();
        exitB.setOnAction(e -> handle_exitsB());
      
        //logoutB
        logoutB = MenuScene.getLogoutB();
        logoutB.setOnAction(e -> handle_logoutB());
        
        

    }
    
    //handle logoutB
	public static void handle_logoutB() {
		MainControl.showLoginScene();
	}

    //handle bookingsB
    public static void handle_bookingsB(){
        MainControl.showViewBookingScene();
    }

    //handle flightsB
    public static void handle_flightsB(){
        MainControl.showViewFlightsScene();
    }

    //handle exitB
    public static void handle_exitsB(){
        MainControl.getWindow().close();
    }

}
