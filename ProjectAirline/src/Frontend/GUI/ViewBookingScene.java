package Frontend.GUI;

import Backend.FlightTable;
import Backend.ReservationsTable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ViewBookingScene {

    private static Scene scene;
    private static Pane layout;
    private static VBox layout2;
    
    private static TableView<ReservationsTable> btable;	//new
    private static TableColumn<ReservationsTable, Integer> ticketNumberCol, flightIDCol;
    private static TableColumn<ReservationsTable, String> useridCol;
    
    private static TableView<FlightTable> ftable;	//new
    private static TableColumn<FlightTable, Integer> flightIDColumn, seatsRemainingColumn;
    private static TableColumn<FlightTable, String> departingCityColumn, departingDateColumn, departingTimeColumn, arrivalCityColumn;
    private static TableColumn<FlightTable, Double> priceColumn;
    
    private static VBox searchVBox, resVBox;	//new 2 searchVBox will have the flight criteria and resVBox will have already made reservations table and delete button
    private static HBox searchHBox, resHBox, row1HBox;	//new 3

    private static DatePicker depDate; //date picker   new 
    
    private static Label reservationL, searchL, allFlightsL;
    private static TextField searchField;
    private static ComboBox<String> fromField, toField; //new 2
    private static Button add_bookingButton, searchB, deleteB; //new
    private static Button backButton;
    private static HBox buttonLayout; //HBOX for bottom section searchfield, book button, and back


    @SuppressWarnings("unchecked")
	public static void initialize(){

    	// Bookings Table
    	btable = new TableView<>();
    	//btable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	btable.setMinSize(150,100);

    	ticketNumberCol = new TableColumn<ReservationsTable, Integer>("Ticket");
    	ticketNumberCol.setCellValueFactory(new PropertyValueFactory<>("ticketNum")); //needs to be same as variable declared in ReservationsTable class

    	useridCol = new TableColumn<ReservationsTable, String>("Username");
    	useridCol.setCellValueFactory(new PropertyValueFactory<>("UserID"));

    	flightIDCol = new TableColumn<ReservationsTable, Integer>("Flight ID");
    	flightIDCol.setCellValueFactory(new PropertyValueFactory<>("FlightID"));

    	btable.getColumns().addAll(ticketNumberCol, useridCol, flightIDCol); 
        //End of bookings table 
        
    	// Flights search table
    	ftable = new TableView<>();
        ftable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ftable.setMinSize(600,300);
        //ftable.relocate(42,32);

        flightIDColumn = new TableColumn<FlightTable, Integer>("ID");
        flightIDColumn.setCellValueFactory(new PropertyValueFactory<>("FlightID"));

        departingCityColumn = new TableColumn<FlightTable, String>("Departing city");
        departingCityColumn.setCellValueFactory(new PropertyValueFactory<>("DepartingCity"));

        departingDateColumn = new TableColumn<FlightTable, String>("Departing date");
        departingDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartingDate"));
 
        departingTimeColumn = new TableColumn<FlightTable, String>("Departing time");
        departingTimeColumn.setCellValueFactory(new PropertyValueFactory<>("DepartingTime"));
        
        arrivalCityColumn = new TableColumn<FlightTable, String>("Arrival city");
        arrivalCityColumn.setCellValueFactory(new PropertyValueFactory<>("ArrivalCity"));

        priceColumn = new TableColumn<FlightTable, Double>("Basic price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));

        seatsRemainingColumn = new TableColumn<FlightTable, Integer>("Available seats");
        seatsRemainingColumn.setCellValueFactory(new PropertyValueFactory<>("SeatsRemaining"));

        ftable.getColumns().addAll(flightIDColumn, departingCityColumn, departingDateColumn, departingTimeColumn, arrivalCityColumn, priceColumn, seatsRemainingColumn);
        //End of flight search table
        
        //VBOX search items
        searchL = new Label("Find your flight");
        
        //From & To fields go inside searchHBox
        fromField = new ComboBox<>();
        fromField.setPromptText("From");
        
        toField = new ComboBox<>();
        toField.setPromptText("To");
        
        searchHBox = new HBox(5);
        searchHBox.setPadding(new Insets(2));
        searchHBox.getChildren().addAll(fromField, toField);
        // searchHBOX created
        
        depDate = new DatePicker();
        depDate.setMinWidth(248);
        
        searchB = new Button("Search");
        
        searchVBox = new VBox(33);
        searchVBox.setPadding(new Insets(10));
        searchVBox.getChildren().addAll(searchL, searchHBox, depDate, searchB);
        // VBOX Search created
        
        deleteB = new Button("Delete");
        
        reservationL = new Label("My confirmed bookings");

        resVBox = new VBox(10);
        resVBox.setPadding(new Insets(10));
        resVBox.getChildren().addAll(reservationL, btable, deleteB);
        resVBox.setAlignment(Pos.CENTER);
        
        row1HBox = new HBox(10);
        row1HBox.getChildren().addAll(searchVBox, resVBox);
        row1HBox.setAlignment(Pos.CENTER);
        
        
        searchField=new TextField();
        searchField.setPromptText("Search by FlightID");
        //searchField.relocate(32,642);
        searchField.setMinWidth(605);

        backButton=new Button("Back");
        add_bookingButton=new Button("Book");
        

        buttonLayout=new HBox();
        buttonLayout.getChildren().addAll(searchField, add_bookingButton,backButton);
        //buttonLayout.relocate(720,642);
        buttonLayout.setPadding(new Insets(10));
        buttonLayout.setSpacing(20);
        
        allFlightsL = new Label("All flights searched or currently available");
        
        layout2 = new VBox(10);
        layout2.getChildren().addAll(row1HBox, allFlightsL, ftable, buttonLayout);
        layout2.setPadding(new Insets(30));
        //layout.getChildren().addAll(btable,buttonLayout,searchField);

        scene = new Scene(layout2,1200,700);
        scene.getStylesheets().add("/Frontend/GUI/style.css");


        System.out.println("bookings scene initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static TableView<ReservationsTable> getBtable() {
        return btable;
    }

    public static TextField getSearchField() {
        return searchField;
    }

    public static Button getAdd_bookingButton() {
        return add_bookingButton;
    }


    public static TableColumn<ReservationsTable, Integer> getTicketNumberCol() {
		return ticketNumberCol;
	}


	public static TableColumn<ReservationsTable, Integer> getFlightIDCol() {
		return flightIDCol;
	}


	public static TableColumn<ReservationsTable, String> getUseridCol() {
		return useridCol;
	}


	public static Button getBackButton() {
        return backButton;
    }


    public static HBox getButtonLayout() {
        return buttonLayout;
    }


	public static TableView<FlightTable> getFtable() {
		return ftable;
	}


	public static TableColumn<FlightTable, Integer> getFlightIDColumn() {
		return flightIDColumn;
	}


	public static TableColumn<FlightTable, Integer> getSeatsRemainingColumn() {
		return seatsRemainingColumn;
	}


	public static TableColumn<FlightTable, String> getDepartingCityColumn() {
		return departingCityColumn;
	}


	public static TableColumn<FlightTable, String> getDepartingDateColumn() {
		return departingDateColumn;
	}


	public static TableColumn<FlightTable, String> getDepartingTimeColumn() {
		return departingTimeColumn;
	}


	public static TableColumn<FlightTable, String> getArrivalCityColumn() {
		return arrivalCityColumn;
	}


	public static TableColumn<FlightTable, Double> getPriceColumn() {
		return priceColumn;
	}


	public static VBox getLayout2() {
		return layout2;
	}


	public static VBox getSearchVBox() {
		return searchVBox;
	}


	public static VBox getResVBox() {
		return resVBox;
	}


	public static HBox getSearchHBox() {
		return searchHBox;
	}


	public static HBox getResHBox() {
		return resHBox;
	}


	public static HBox getRow1HBox() {
		return row1HBox;
	}


	public static DatePicker getDepDate() {
		return depDate;
	}


	public static ComboBox<String> getFromField() {
		return fromField;
	}


	public static ComboBox<String> getToField() {
		return toField;
	}


	public static Button getSearchB() {
		return searchB;
	}


	public static Button getDeleteB() {
		return deleteB;
	}
}
