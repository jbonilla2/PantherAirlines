package Frontend.GUI;

import java.sql.SQLException;

import Backend.FlightTable;
import Frontend.SceneControl.*;
import databaseAccess.DBconnect;
import databaseAccess.FlightTableData;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);
    	/*
    	for(FlightTable temp : FlightTableData.getFlightItems()) {
    		System.out.println(temp.getFlightID() + " " + temp.getArrivalCity() + " " + temp.getDepartingCity());
    	}
    	
    	System.out.println(FlightTableData.getFlightItems().get(0).getFlightID());
		*/    
    }
    


    //start method
    public void start(Stage primaryStage)throws Exception {

        //show the login screen
        MainControl.showLoginScene();

    }

}