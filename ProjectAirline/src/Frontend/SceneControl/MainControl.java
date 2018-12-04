package Frontend.SceneControl;

import java.sql.Connection;

import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import databaseAccess.DBconnect;
import Frontend.GUI.LoginScene;
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

    //register scene
    public static void showForgotPassScene() {
    	//connect to database
    	Connection conn = DBconnect.connect();

    	//initialization of scene
    	RegisterScene.initialize();
    	
    	//initialization of controller
    	//RegisterSceneControl.initialize();
    	
    	//set scene
    	window.setScene(RegisterScene.getScene());
    	window.setTitle("Panther Airlines - Forgot Password");
    	window.centerOnScreen();
    }
    
    //menu scene
    public static void showMenuScene(){
        //initialization of scene
        MenuScene.initialize();

        //initialization of controller
        MenuSceneControl.initialize();

        //set scene
        window.setScene(MenuScene.getScene());
        window.setTitle("Panther Airlines™");
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
        window.setTitle("Panther Airlines™");      

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
        window.setTitle("Panther Airlines™  -  Bookings");
        window.centerOnScreen();
    }


    //view customers scene
    public static void showViewCustomerScene(){
        //initialization of scene
        ViewCustomersScene.initialize();

        //initialization of controller
        ViewCustomerSceneControl.initialize();

        //set scene
        window.setScene(ViewCustomersScene.getScene());
        window.setTitle("Panther Airlines™  -  Customers");
        window.centerOnScreen();
    }


    //view flights scene
    public static void showViewFlightsScene(){
        //initialization of scene
        ViewFlightsScene.initialize();

        //initialization of controller
        ViewFlightSceneControl.initialize();

        //set scene
        window.setScene(ViewFlightsScene.getScene());
        window.setTitle("Panther Airlines™  -  Flights");
        window.centerOnScreen();
    }

    //flight edit dialog
    public static boolean showFlightEditScene(FlightTable flightTable, Flight flight){
        //initialization of scene
        FlightsEditScene.initialize();

        //initialization of controller
        FlightEditSceneControl.initialize();
        //FlightEditSceneControl.setFlight(flightTable,flight);

        FlightsEditScene.getDialogStage().initOwner(window);
        FlightsEditScene.getDialogStage().setTitle("Flight menu");
        FlightsEditScene.getDialogStage().showAndWait();

        return FlightEditSceneControl.isOkPressed();
    }


    //booking edit dialog
    public static boolean showBookingEditScene(ReservationsTable bookingTable, Reservations booking) {
        //initialization of scene
        BookingEditScene.initialize();

        //initialization of controller
        BookingEditSceneControl.initialize();
// Come back to edit  BookingEditSceneControl.setBooking(bookingTable, booking);

        BookingEditScene.getDialogStage().initOwner(window);
        BookingEditScene.getDialogStage().setTitle("Booking menu");
        BookingEditScene.getDialogStage().showAndWait();

        return BookingEditSceneControl.isOkPressed();

    }



    //getters
    public static Stage getWindow() {
        return window;
    }

}
