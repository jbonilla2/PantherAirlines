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
import java.util.Optional;

public class ViewBookingSceneControl {

    //fields
    private static TableView<ReservationsTable> table;
    private static ObservableList<ReservationsTable> reservations, tableItems;  
    
    private static TextField search;
    private static Button add_bookingButton;
    private static Button cancelButton;
    private static Button backButton;
    private static Button editButton;
    
    //initialize method
    public static void initialize() {

        //table
    	table = ViewBookingScene.getTable();
        try {
			table.setItems(FlightTableData.getFlightItems());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //buttons
        add_bookingButton = ViewBookingScene.getAdd_bookingButton();
        add_bookingButton.setOnAction(e -> handle_addButton());

        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());

        //search field setup
        search = ViewBookingScene.getSearchField();
        reservations = table.getItems();
        initializeSearch();
    }


    //back button action
    public static void handle_backButton() {
        MainControl.showMenuScene();
    }


    //add button action
    public static void handle_addButton(){
    	ReservationsTable reservationTable = new ReservationsTable();
    	Reservations reservation = new Reservations();


    }


    //search bar setup
    public static void initializeSearch(){
        search.textProperty().addListener(new InvalidationListener() {
           
        	@Override
            public void invalidated(Observable observable) {
                if (search.textProperty().get().isEmpty()) {
                    table.setItems(reservations);
                    return;
                }

                tableItems = FXCollections.observableArrayList();

                for(ReservationsTable b : reservations){
                    if(b.getRoute().toUpperCase().contains(search.getText().toUpperCase())||
                            b.getUser().toUpperCase().contains(search.getText().toUpperCase())) {

                        tableItems.add(b);
                    }
                }

                table.setItems(tableItems);
            }
        });
    }

}
