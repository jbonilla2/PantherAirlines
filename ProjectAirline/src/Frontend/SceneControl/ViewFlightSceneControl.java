package Frontend.SceneControl;

import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class ViewFlightSceneControl {


    private static TableView<FlightTable> table;
    private static ObservableList<FlightTable> flights, tableItems;
    private static TextField search;
    private static Button backB, addB, deleteFlightsB;
   
    
    public static void initialize(){

        table = ViewFlightsScene.getTable();
        try {
			table.setItems(FlightTableData.getFlightItems());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        
        addB = ViewFlightsScene.getAddB();
        addB.setOnAction(e -> handle_addB());

        deleteFlightsB = ViewFlightsScene.getDeleteFlightsB();
        deleteFlightsB.setOnAction(event -> handle_deleteFlightsB());
        
        backB = ViewFlightsScene.getBackB();
        backB.setOnAction(e -> handle_backB());
        
        search = ViewFlightsScene.getSearch();
        flights = table.getItems(); //set search arrayList items
        initializeSearch();

    }



    //add button action
    public static void handle_addB() {
    	int access = 0;
    	String user = LoginSceneControl.getUsername();
    	if(user.contentEquals("admin")) {
    		MainControl.showFlightEditScene();
    		try {
				table.setItems(FlightTableData.getFlightItems());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		access =+ 1;
    	}
    	if(access == 0) {
    		
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.initOwner(MainControl.getWindow());
    		alert.setContentText("FOR ADMIN ONLY");
    		alert.showAndWait();
    		System.out.println("A CUSTOMER ATTEMPTED TO CHANGE A FLIGHT");
    	}	
    	
    }

    //back button action
    public static void handle_backB(){ MainControl.showMenuScene(); }
  

    //delete button action
    public static void handle_deleteFlightsB() {
    	int access = 0;
    	String user = LoginSceneControl.getUsername();
    	if(user.contentEquals("admin")) {
	    	
	    	ObservableList<FlightTable> selFlight, allFlight;
	    	
	    	FlightTable selectFlight = new FlightTable();
	
	        allFlight = table.getItems();
	        selFlight = table.getSelectionModel().getSelectedItems();
	        
	        selectFlight = table.getSelectionModel().getSelectedItem();
	        FlightTableData.deleteFlight(selectFlight);
	        
	        try {
				table.setItems(FlightTableData.getFlightItems());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	        access =+ 1;  
    	} 
    	if(access == 0) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.initOwner(MainControl.getWindow());
    		alert.setContentText("FOR ADMIN ONLY");
    		alert.showAndWait();
    		System.out.println("A CUSTOMER ATTEMPTED TO CHANGE A FLIGHT");
    	}
    }

    
    public static void initializeSearch(){
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (search.textProperty().get().isEmpty()) {
                    table.setItems(flights);
                    return;
                }

                tableItems = FXCollections.observableArrayList();

                for(FlightTable f : flights){
                    if(f.getFlightID() == Integer.parseInt(search.getText()) || f.getDepartingCity().toUpperCase().contains(search.getText().toUpperCase()) ||
                            f.getArrivalCity().toUpperCase().contains(search.getText().toUpperCase())){
                        tableItems.add(f);
                    }
                }

                table.setItems(tableItems);
            }
        });
    }



	public static TableView<FlightTable> getTable() {
		return table;
	}



	public static ObservableList<FlightTable> getFlights() {
		return flights;
	}



	public static ObservableList<FlightTable> getTableItems() {
		return tableItems;
	}



	public static TextField getSearch() {
		return search;
	}



	public static Button getBackB() {
		return backB;
	}



	public static Button getAddB() {
		return addB;
	}


	public static Button getDeleteFlightsB() {
		return deleteFlightsB;
	}

}
