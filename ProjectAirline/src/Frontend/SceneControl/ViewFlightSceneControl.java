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
    private static Button backB, addB, editB, deleteFlightsB;


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

        backB = ViewFlightsScene.getBackB();
        backB.setOnAction(e -> handle_backB());
        
        addB = ViewFlightsScene.getAddB();
        addB.setOnAction(e -> handle_addB());

        editB = ViewFlightsScene.getEditB();
       // editB.setOnAction(e -> handle_editB());

        deleteFlightsB = ViewFlightsScene.getDeleteFlightsB();
        deleteFlightsB.setOnAction(event -> handle_deleteFlightsB());


        search = ViewFlightsScene.getSearch();
        flights = table.getItems(); //set search arrayList items
        initializeSearch();

    }



    //add button action
    public static void handle_addB() {
        FlightTable flightTable = new FlightTable(LocalDate.now().toString());
        //Flight flight = new Flight();

        MainControl.showFlightEditScene();
/*
        if(okPressed) {
            flight = FlightEditSceneControl.getFlight();

            FlightData.insertFlight(flight); //add flight to database

            try {
				table.setItems(FlightTableData.getFlightItems());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //set the table items
            flights = table.getItems();
*/
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Flight added!");
            alert.showAndWait();
            System.out.println("new flight added");
        //}
    }


/*
    //edit button action
    public static void handle_editB(){
    	ObservableList<FlightTable> selFlight = table.getSelectionModel().getSelectedItems();
        FlightTable flight = new FlightTable();

        if(selFlight != null) {
            boolean okPressed = MainControl.showFlightEditScene();

            if (okPressed) {
                flight = FlightEditSceneControl.getFlight();
                //FlightTableData.updateFlight(flight); //update flight in database

                try {
					table.setItems(FlightTableData.getFlightItems());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //set the table items
                flights = table.getItems();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initOwner(MainControl.getWindow());
                alert.setContentText("Flight edited!");
                alert.showAndWait();

                System.out.println("a flight edited");
            }
        }

        else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(MainControl.getWindow());
                alert.setHeaderText("Select flight!");
                alert.setContentText("No flight selected!");
                alert.showAndWait();
            }

    }
*/


    //back button action
    public static void handle_backB(){ MainControl.showMenuScene(); }
  

    //delete button action
    public static void handle_deleteFlightsB() {
    	
    	ObservableList<FlightTable> selFlight, allFlight;
    	
    	FlightTable selectFlight = new FlightTable();

        allFlight = table.getItems();
        selFlight = table.getSelectionModel().getSelectedItems();
        
        selFlight.forEach(allFlight::remove);
        
        selectFlight = table.getSelectionModel().getSelectedItem();
        
        FlightTableData.deleteFlight(selectFlight);
        
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
                    if(f.getDepartingCity().toUpperCase().contains(search.getText().toUpperCase()) ||
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



	public static Button getEditB() {
		return editB;
	}



	public static Button getDeleteFlightsB() {
		return deleteFlightsB;
	}

}
