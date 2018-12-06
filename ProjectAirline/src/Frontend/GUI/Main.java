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
    	  
    }    
    
    public void start(Stage primaryStage) throws Exception {

        MainControl.showLoginScene();

    }

}