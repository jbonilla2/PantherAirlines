package Frontend.SceneControl;

import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Optional;

public class ViewBookingSceneControl {

    //fields
    private static TableView<ReservationsTable> table;
    private static Label departure_dateObs;
    private static Label arrival_dateObs;
    private static Label categoryObs;
    private static Label priceObs;

    private static Label first_nameObs;
    private static Label last_nameObs;
    private static Label ageObs;
    private static Label passportObs;
    private static Label phone_numberObs;

    private static TextField search;
    private static Button add_bookingButton;
    private static Button cancelButton;
    private static Button backButton;
    private static Button editButton;

    private static ObservableList<ReservationsTable> reservations, tableItems;
    private static double refund;


    //initialize method
    public static void initialize() {

        //table
        table = ViewBookingScene.getTable();
        table.setItems(ReservationsTableData.getReservationsTableItems());
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> displayBookingInfo(newValue));

        //flight info labels
        departure_dateObs = ViewBookingScene.getDeparture_dateObs();
        arrival_dateObs = ViewBookingScene.getArrival_dateObs();
        categoryObs = ViewBookingScene.getCategoryObs();
        priceObs = ViewBookingScene.getPriceObs();

        //customer info labels
        first_nameObs = ViewBookingScene.getFirst_nameObs();
        last_nameObs = ViewBookingScene.getLast_nameObs();
        ageObs = ViewBookingScene.getAgeObs();
        passportObs = ViewBookingScene.getPassportObs();
        phone_numberObs = ViewBookingScene.getPhone_numberObs();

        //buttons
        add_bookingButton = ViewBookingScene.getAdd_bookingButton();
        add_bookingButton.setOnAction(e -> handle_addButton());

        cancelButton = ViewBookingScene.getCancelButton();
        cancelButton.setOnAction(e -> handle_cancelButton());

        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());

        editButton = ViewBookingScene.getEditButton();
       // editButton.setOnAction(e -> handle_editButton());


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

        boolean okPressed = MainControl.showBookingEditScene(reservationTable, reservation);

        if (okPressed) {
        	reservation = BookingEditSceneControl.getReservation();
        	
            reservations = table.getItems();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Booking added!");
            alert.showAndWait();

            System.out.println("new booking added");
        }

    }

/*
    //edit button action
    public static void handle_editButton(){
    	ReservationsTable bookingTable = table.getSelectionModel().getSelectedItem();
    	Reservations booking = new Reservations();

        if(bookingTable != null) {
            //assuming that the customer is going to change the ticket category
            for(Flight f: FlightData.getFlight()){
                if(booking.getFlight_id()==f.getFlight_id())
                    if(booking.getFare_class().equalsIgnoreCase("first class"))
                        f.setFirst_class_left(f.getFirst_class_left() + 1);
                    else if(booking.getFare_class().equalsIgnoreCase("coach"))
                        f.setCoach_left(f.getCoach_left() + 1);
                    else f.setEconomy_left(f.getEconomy_left() + 1);
                FlightData.updateFlight(f);
                break;
            }

            boolean okPressed = MainControl.showBookingEditScene(bookingTable, booking);

            if (okPressed) {
                booking = BookingEditSceneControl.getBooking();
                BookingData.updateBooking(booking); //edit booking in database

                table.setItems(BookingTableData.getBookingTableItems()); //set the table items
                table.getSelectionModel().select(bookingTable);
                bookings = table.getItems();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initOwner(MainControl.getWindow());
                alert.setContentText("Booking edited!");
                alert.showAndWait();

                System.out.println("a booking edited");
            }
        }

        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select booking!");
            alert.setContentText("No booking selected!");
            alert.showAndWait();
        }
    }
*/

    //remove button action
    public static void handle_cancelButton() {
        ReservationsTable reservationsTable = table.getSelectionModel().getSelectedItem();
        Reservations reservation = new Reservations();

        if (reservationsTable != null) {
            refund = 0.0;
            for (Reservations b : ReservationsData.getReservations())
                if (reservationsTable.getTicketNum() == b.getTicketNum()) {
                    reservation = b;
                    break;
                }

                for (Flight f : FlightData.getFlight())
                    if (f.getFlightID() == reservation.getFlightID()) {
                            refund = f.getPrice() * 70/100;

                        break;
                    }

                cancelReservation(reservationsTable, reservation);
            }

        else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(MainControl.getWindow());
                alert.setHeaderText("Select booking!");
                alert.setContentText("No booking selected!");
                alert.showAndWait();
            }
    }


    //method to cancel a booking
    public static void cancelReservation(ReservationsTable reservationTable, Reservations reservation) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(MainControl.getWindow());
        alert.setHeaderText("Remove booking");
        alert.setContentText("Are you sure you want to cancel " + reservationTable.getUser() + "'s booking?" +
                "\nThe refund will be " + refund + " kr.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) { //confirmed

            ReservationsData.deleteReservation(reservation); //delete booking from database

            table.setItems(ReservationsTableData.getReservationsTableItems()); //set table items
            reservations = table.getItems();

            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.initOwner(MainControl.getWindow());
            alert1.setContentText("Booking canceled!\n"
                    + reservationTable.getUser() + " was refunded " + refund + " kr.");
            alert1.showAndWait();

            //set left seats
            for (Flight f : FlightData.getFlight())
                if (f.getFlightID() == reservation.getFlightID()) {
                        f.setSeatsRemaining(f.getSeatsRemaining() + 1);
                }

            System.out.println("a booking removed");
        }
        else {
            alert.close();
        }
    }


    //method to display the booking details
    public static void displayBookingInfo(ReservationsTable buk) {
        if(buk != null) {

            Reservations reservations = new Reservations();
            for(Reservations b : ReservationsData.getReservations())
                if(b.getTicketNum() == buk.getTicketNum()) {
                	reservations = b;
                    break;
                }

            FlightTable flight = new FlightTable();
            for(FlightTable f : FlightTableData.getFlightTableItems())
                if(f.getFlightID() == reservations.getFlightID()) {
                    flight = f;
                    break;
                }

            User user = new User();
            for(User u : UserData.getUsers())
                if(u.getUsername() == reservations.getUserID()) {
                    user = u;
                    break;
                }


            departure_dateObs.setText(flight.getDeparture_date() + ", " + flight.getDeparture_city());
            arrival_dateObs.setText(flight.getDeparture_date() + ", " + flight.getArrival_city());
            categoryObs.setText(booking.getFare_class());

            if(booking.getFare_class().equalsIgnoreCase("first class"))
            priceObs.setText(String.valueOf(flight.getPrice()+flight.getPrice()*1/2) + " kr.");
            else if(booking.getFare_class().equalsIgnoreCase("coach"))
                priceObs.setText(String.valueOf((flight.getPrice()+flight.getPrice()*1/4) + " kr."));
            else
                priceObs.setText(String.valueOf(flight.getPrice() + " kr."));


            first_nameObs.setText(customer.getFirst_name());
            last_nameObs.setText(customer.getLast_name());
            ageObs.setText(String.valueOf(customer.getAge()));
            passportObs.setText(customer.getPassport_number());
            phone_numberObs.setText(customer.getPhone_nr());
        }

        else { //no selection
            departure_dateObs.setText("");
            arrival_dateObs.setText("");
            categoryObs.setText("");
            priceObs.setText("");
            first_nameObs.setText("");
            last_nameObs.setText("");
            ageObs.setText("");
            passportObs.setText("");
            phone_numberObs.setText("");
        }
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
