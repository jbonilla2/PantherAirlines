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

public class ViewBookingSceneControl {

    private static TableView<ReservationsTable> btable;
    private static ObservableList<ReservationsTable> reservations, resTableItems;  
    
    private static TableView<FlightTable> ftable;
    private static ObservableList<FlightTable> flights, flightTableItems;
    
    private static TextField searchField; 
    private static ComboBox<String> fromField, toField;
    private static String fromS, toS, depDateS;
    private static Button add_bookingButton, searchB, deleteB;
    private static Button backButton;
    
    private static DatePicker depDate;
    
    
    public static void initialize() {
    	
    	String user = LoginSceneControl.getUsername();
    	btable = ViewBookingScene.getBtable();
    	try {
			btable.setItems(ReservationsTableData.getReservationsTableItems(user));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	ftable = ViewBookingScene.getFtable();
        try {
			ftable.setItems(FlightTableData.getFlightItems());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        fromField = ViewBookingScene.getFromField();
        fromField.getItems().addAll("ATL", "MIA", "LAX", "JFK");

        
        toField = ViewBookingScene.getToField();
        toField.getItems().addAll("ATL", "MIA", "LAX", "JFK");
        
        
        depDate = ViewBookingScene.getDepDate();

        
        deleteB = ViewBookingScene.getDeleteB();
        deleteB.setOnAction( e -> handle_deleteB());
        
        searchB = ViewBookingScene.getSearchB();
        searchB.setOnAction( e -> handle_searchB());
        
        add_bookingButton = ViewBookingScene.getAdd_bookingButton();
        add_bookingButton.setOnAction(e -> handle_addButton());

        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());

        searchField = ViewBookingScene.getSearchField();
        
        flights = ftable.getItems();
        reservations = btable.getItems();
        
        initializeSearch();
        
    }
    
    public static void handle_searchB() {
        
    	fromS = fromField.getSelectionModel().getSelectedItem().toString();
    	toS = toField.getSelectionModel().getSelectedItem().toString();
        depDateS = depDate.getValue().toString();
        System.out.println(fromS + " " + toS + " " + depDateS);
    	try {
			ftable.setItems(FlightTableData.searchFlightItems(fromS, toS, depDateS));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void handle_backButton() {
        MainControl.showMenuScene();
    }


    public static void handle_addButton(){
    	ObservableList<FlightTable> selFlight;
    	
    	FlightTable selectFlight = new FlightTable();

        selFlight = ftable.getSelectionModel().getSelectedItems();
        
        String user = LoginSceneControl.getUsername();
        
        selectFlight = ftable.getSelectionModel().getSelectedItem();
        ReservationsTableData.addReservation(selectFlight, user);
        
        int flightID = selectFlight.getFlightID();
        ReservationsTableData.deleteSeat(flightID);
        
        try {
			btable.setItems(ReservationsTableData.getReservationsTableItems(user));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        try {
			ftable.setItems(FlightTableData.getFlightItems());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    
    	System.out.println("new booking added");

    }

    public static void handle_deleteB(){

    	ObservableList<ReservationsTable> selRes, allRes;
    	
    	ReservationsTable selectReserv = new ReservationsTable();

        allRes = btable.getItems();
        selRes = btable.getSelectionModel().getSelectedItems();
        
        selectReserv = btable.getSelectionModel().getSelectedItem();
        ReservationsTableData.deleteReservation(selectReserv);
        
        String user = LoginSceneControl.getUsername();
        
        try {
			btable.setItems(ReservationsTableData.getReservationsTableItems(user));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	
        int flightID = selectReserv.getFlightID();
        ReservationsTableData.addSeat(flightID);
        
        try {
			ftable.setItems(FlightTableData.getFlightItems());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


   public static void initializeSearch() {
        searchField.textProperty().addListener(new InvalidationListener() {
           //all this needs to be changed to flight table ftable association so that it can search through flights
        	@Override
            public void invalidated(Observable observable) {
                if (searchField.textProperty().get().isEmpty()) {
                    ftable.setItems(flights);
                    return;
                }

                flightTableItems = FXCollections.observableArrayList();

                for(FlightTable f : flights){
                    if(f.getFlightID() == Integer.parseInt(searchField.getText())|| f.getDepartingCity().toUpperCase().contains(searchField.getText().toUpperCase()) ||
                            f.getArrivalCity().toUpperCase().contains(searchField.getText().toUpperCase()) ) {
                        flightTableItems.add(f);
                    }
                }

                ftable.setItems(flightTableItems);
            }
        });
   }

}
