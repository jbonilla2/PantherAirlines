package Frontend.GUI;

import Backend.Reservations;
import Backend.ReservationsTable;
import Backend.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Date;

public class ViewBookingScene {

    //fields
    private static Scene scene;
    private static Pane layout;
    private static TableView<ReservationsTable> table;
    private static TableColumn<ReservationsTable, String> dateColumn;
    private static TableColumn<ReservationsTable, String> nameColumn;
    private static TableColumn<ReservationsTable, String> routeColumn;
    private static Label flightLabel;
    private static Label departureDateLabel;
    private static Label departureDateObs;
    private static Label arrivalDateLabel;
    private static Label arrivalDateObs;
    private static Label flightIDObs;    // instead of depDate, A
    private static Label ticketNumObs;
    private static Label userIDObs;
    private static Label categoryLabel;
    private static Label categoryObs;
    private static Label priceLabel;
    private static Label priceObs;
    private static VBox flight_details;
    private static VBox flight_detailsObs;

    private static Label customer_detailsLabel;
    
    private static VBox customer_detailsVertical;
    private static VBox customer_detailsVerticalObs;

    private static TextField searchField;
    private static Button add_bookingButton;
    private static Button cancelButton;
    private static Button backButton;
    private static Button editButton;
    private static HBox buttonLayout;


    //initialization of objects
    public static void initialize(){

        //table columns
        dateColumn=new TableColumn<>("Departure date");
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().departingDateProperty());

        nameColumn=new TableColumn<>("Customer name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().userProperty());

        routeColumn=new TableColumn<>("\t\t\tRoute");
        routeColumn.setMinWidth(160);
       // routeColumn.setCellValueFactory(cellData -> cellData.getValue().routeProperty());


        //table
        table=new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(dateColumn, routeColumn, nameColumn);    // edit these columns 
        table.relocate(32,34);
        table.setMinWidth(610);
        table.setMinHeight(580);

        //searchField
        searchField=new TextField();
        searchField.setPromptText("search");
        searchField.relocate(32,642);
        searchField.setMinWidth(605);

        //buttons
        backButton=new Button("Back");
        add_bookingButton=new Button("Add..");
        editButton=new Button("Edit..");
        cancelButton=new Button("Remove");


        // layout for buttons
        buttonLayout=new HBox();
        buttonLayout.getChildren().addAll(add_bookingButton,editButton,cancelButton,backButton);
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

    public static TableColumn<ReservationsTable, String> getDateColumn() {
        return dateColumn;
    }

    public static TableColumn<ReservationsTable, String> getNameColumn() {
        return nameColumn;
    }

    public static TableColumn<ReservationsTable, String> getRouteColumn() {
        return routeColumn;
    }

    public static Label getFlightLabel() {
        return flightLabel;
    }

    public static Label getDepartureDateLabel() {
        return departureDateLabel;
    }

    public static Label getDepartureDateObs() {
        return departureDateObs;
    }

    public static Label getArrivalDateLabel() {
        return arrivalDateLabel;
    }

    public static Label getArrivalDateObs() {
        return arrivalDateObs;
    }

    public static Label getCategoryLabel() {
        return categoryLabel;
    }

    public static Label getCategoryObs() {
        return categoryObs;
    }

    public static Label getPriceLabel() {
        return priceLabel;
    }

    public static Label getPriceObs() {
        return priceObs;
    }

    public static VBox getFlight_details() {
        return flight_details;
    }

    public static VBox getFlight_detailsObs() {
        return flight_detailsObs;
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

    public static Button getCancelButton() {
        return cancelButton;
    }

    public static Button getBackButton() {
        return backButton;
    }

    public static Button getEditButton() {
        return editButton;
    }

    public static HBox getButtonLayout() {
        return buttonLayout;
    }
}
