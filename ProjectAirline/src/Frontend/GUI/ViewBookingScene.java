package Frontend.GUI;

import Backend.Reservations;
import Backend.ReservationsTable;
import Backend.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Date;

public class ViewBookingScene {

    //fields
    private static Scene scene;
    private static Pane layout;
    private static TableView<ReservationsTable> table;
    private static TableColumn<ReservationsTable, Integer> ticketNumber, flightID;
    private static TableColumn<ReservationsTable, String> dCity, aCity, userid;
  
    private static Label customer_detailsLabel;
    
    private static VBox customer_detailsVertical;
    private static VBox customer_detailsVerticalObs;

    private static TextField searchField;
    private static Button add_bookingButton;
    private static Button backButton;
    private static HBox buttonLayout;


    //initialization of objects
    public static void initialize(){

        //table columns
    	ticketNumber=new TableColumn<>("Ticket");
    	ticketNumber.setCellValueFactory(new PropertyValueFactory<>("ticketNumber"));

    	userid=new TableColumn<>("Username");
    	userid.setCellValueFactory(new PropertyValueFactory<>("UserID"));

    	flightID=new TableColumn<>("Flight ID");
    	flightID.setCellValueFactory(new PropertyValueFactory<>("FlightID"));

        dCity=new TableColumn<>("Departing City");
        dCity.setCellValueFactory(new PropertyValueFactory<>("DepartingCity"));

        aCity=new TableColumn<>("Arrival City");
        aCity.setCellValueFactory(new PropertyValueFactory<>("ArrivalCity"));


        //table
        table=new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(ticketNumber, userid, flightID,dCity,aCity); 
        table.relocate(32,34);
        table.setMinSize(1116,580);

        //searchField
        searchField=new TextField();
        searchField.setPromptText("search");
        searchField.relocate(32,642);
        searchField.setMinWidth(605);

        //buttons
        backButton=new Button("Back");
        add_bookingButton=new Button("Book");
        


        // layout for buttons
        buttonLayout=new HBox();
        buttonLayout.getChildren().addAll(add_bookingButton,backButton);
        buttonLayout.relocate(720,642);
        buttonLayout.setSpacing(20);

        //LAYOUT
        layout=new Pane();
        layout.getChildren().addAll(table,buttonLayout,searchField);

        //Scene
        scene = new Scene(layout,1200,700);
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

    public static TableView<ReservationsTable> getTable() {
        return table;
    }

       public static Label getCustomer_detailsLabel() {
        return customer_detailsLabel;
    }

    public static VBox getCustomer_detailsVertical() {
        return customer_detailsVertical;
    }

    public static VBox getCustomer_detailsVerticalObs() {
        return customer_detailsVerticalObs;
    }

    public static TextField getSearchField() {
        return searchField;
    }

    public static Button getAdd_bookingButton() {
        return add_bookingButton;
    }


    public static Button getBackButton() {
        return backButton;
    }


    public static HBox getButtonLayout() {
        return buttonLayout;
    }
}
