package Frontend.SceneControl;

import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class FlightEditSceneControl {

    private static TextField price,flight_id,seatsT;
    private static ComboBox<String> dcityC, acityC, departure_time;
    private static DatePicker departure_date, arrival_date;
    private static Button okB, cancelB;
    private static boolean okPressed = false;
    private static FlightTable flight;


    public static void initialize(){

        price = FlightsEditScene.getPrice();
        
        seatsT = FlightsEditScene.getSeatsT();
       
        dcityC = FlightsEditScene.getDcityC();
        dcityC.getItems().addAll("ATL", "MIA", "LAX");      
        
        acityC = FlightsEditScene.getAcityC();
        acityC.getItems().addAll("ATL", "MIA", "LAX");
        
        flight_id = FlightsEditScene.getFlight_id();
         
        departure_time= FlightsEditScene.getDeparture_time();
        
        //adds 24 hours to times to be displayed in combo box 
        ObservableList<String> times = FXCollections.observableArrayList();
        for(int i=1; i<=24; i++) {
            times.add(i + ":00");
        }
        departure_time.setItems(times);       
        //departure date picker
        departure_date = FlightsEditScene.getDeparture_date();
        //arrival date picker
        arrival_date = FlightsEditScene.getArrival_date();

        FlightTable newflight = new FlightTable(Integer.parseInt(flight_id.getText()), dcityC.toString(), departure_date.toString(), departure_time.toString(), acityC.toString(), arrival_date.toString(), Double.parseDouble(price.getText()), Integer.parseInt(seatsT.getText()) );
        
        FlightTableData.insertFlight(newflight);

        //ok button
        okB = FlightsEditScene.getOkB();
        okB.setOnAction( e -> handle_okB());


        //cancel button
        cancelB = FlightsEditScene.getCancelB();
        cancelB.setOnAction( e-> handleClose());

    }




    //ok button action
    public static void handle_okB(){
        if(isInputValid()){

        flight.setFlightID(Integer.parseInt(flight_id.getText()));


        try {
			for(FlightTable f: FlightTableData.getFlightItems()) {
				if(f.getFlightID() == Integer.parseInt(flight_id.getText())) {
					
					Alert alert = new Alert(Alert.AlertType.WARNING);
			        alert.setHeaderText("Flight exists!");
			        alert.setContentText("Input data again!");
			        alert.initOwner(MainControl.window);
			        alert.showAndWait();
			 	   
			    }
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        FlightsEditScene.getDialogStage().close();
        }

    }


    //cancel button action
    public static void handleClose(){
        okPressed = false;
        FlightsEditScene.getDialogStage().close();
    }


    //method to verify user input
    public static boolean isInputValid(){
        String error = "";

       if(dcityC.getValue().equalsIgnoreCase(" -> "))
        error += "Invalid route!\n";

        try {

        if(Double.parseDouble(price.getText()) < 10)
            error+="Invalid base price!\n";
            Double.parseDouble(price.getText());
        }
        catch(NumberFormatException e){
            error += "Invalid base price!\n";
        }

        if(error=="")
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(FlightsEditScene.getDialogStage());
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.showAndWait();
            return false;
        }
    }


    //getters
    public static FlightTable getFlight() {
        return flight;
    }

    public static boolean isOkPressed(){ return okPressed; }

}
