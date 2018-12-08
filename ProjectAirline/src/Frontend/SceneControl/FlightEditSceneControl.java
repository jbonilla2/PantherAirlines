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
    private static Button addB, editB, cancelB;
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
        //arrival_date = FlightsEditScene.getArrival_date();

        //add button
        addB = FlightsEditScene.getAddB();
        addB.setOnAction( e -> handle_addB());

        //edit button
        editB = FlightsEditScene.getEditB();
        editB.setOnAction( e -> handle_editB());

        //cancel button
        cancelB = FlightsEditScene.getCancelB();
        cancelB.setOnAction( e-> handleClose());

        //flight = new FlightTable(Integer.parseInt(flight_id.getText()), dcityC.getSelectionModel().getSelectedItem().toString(), departure_date.getValue().toString(), departure_time.getSelectionModel().getSelectedItem().toString(), acityC.getSelectionModel().getSelectedItem().toString(), arrival_date.getValue().toString(), Double.parseDouble(price.getText()), Integer.parseInt( seatsT.getText() ) );
        
    }

    public static void handle_editB() {
    	int ok = 0;
    	flight = new FlightTable(Integer.parseInt(flight_id.getText()), dcityC.getSelectionModel().getSelectedItem().toString(), departure_date.getValue().toString(), departure_time.getSelectionModel().getSelectedItem().toString(), acityC.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(price.getText()), Integer.parseInt( seatsT.getText() ) );
    	
    	if(isInputValid()){
    	
	    	try {
	    		for(FlightTable f: FlightTableData.getFlightItems()) {
	    			if(f.getFlightID() == flight.getFlightID()) {
						
	    				okPressed = true;
	    				FlightTableData.updateFlight(flight);
	    				FlightsEditScene.getDialogStage().close();
	    				ok = 1;
	    				break;
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
			
			if(ok==0) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setHeaderText("Flight ID does not match!");
				alert.setContentText("Match flight ID to existing ID!" );
				alert.initOwner(MainControl.window);
				alert.showAndWait();
				
				FlightsEditScene.getDialogStage().close();
			}
    	}	
    }


    //ok button action
    public static void handle_addB(){
    	int ok = 0;

    	//committ made
    	flight = new FlightTable(Integer.parseInt(flight_id.getText()), dcityC.getSelectionModel().getSelectedItem().toString(), departure_date.getValue().toString(), departure_time.getSelectionModel().getSelectedItem().toString(), acityC.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(price.getText()), Integer.parseInt( seatsT.getText() ) );
    	
        if(isInputValid()){
        	
        	//Should insert a new flight to the database
        	
        	try {
        		for(FlightTable f: FlightTableData.getFlightItems()) {
        			if(f.getFlightID() == Integer.parseInt(flight_id.getText())) {
    					
        				Alert alert = new Alert(Alert.AlertType.WARNING);
        				alert.setHeaderText("Flight exists!");
        				alert.setContentText("Input data again!");
        				alert.initOwner(MainControl.window);
        				alert.showAndWait();
            				
        				ok = 1;
        				break;
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
        		
        	if(ok==0) {
        		FlightTableData.insertFlight(flight);
        		FlightsEditScene.getDialogStage().close();
        	} //closes if(ok==0)
        } //closes if(ViewFlightSceneControl.getAddB().isPressed())
        	
        
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
        error += "Invalid departing city!\n";

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
