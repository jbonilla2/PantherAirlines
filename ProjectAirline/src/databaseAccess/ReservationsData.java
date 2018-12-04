package databaseAccess;

import Backend.Reservations;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class ReservationsData {

    //fields
    private static Statement statement;
    private static ObservableList<Reservations> reservations;
    private static Connection conn = DBconnect.connect();



    //get bookings
    public static ObservableList<Reservations> getReservations(){
    	reservations = FXCollections.observableArrayList();

        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM reservations");

            if(rs != null)
                while (rs.next()) {
                    Reservations reservation = new Reservations();
                    reservation.setTicketNum(rs.getInt(1));
                    reservation.setUserID(rs.getInt(2));
                    reservation.setFlightID(rs.getInt(3));

                    reservations.add(reservation);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return reservations;
    }


    public static void insertReservation(Reservations reservation) {
        
    	try{
            statement.executeUpdate("INSERT INTO reservations VALUE(" + reservation.getUserID() + ", " + reservation.getFlightID() + ", '" + reservation.getTicketNum() + "');");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to edit a booking
    public static void updateReservation(Reservations reservation){
        try{
            statement.executeUpdate("UPDATE reservations SET userID = " + reservation.getUserID() + ", flightID = " + reservation.getFlightID() + "' WHERE ticketNumber = " + reservation.getTicketNum() + ";" );
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }



    //method to remove a booking
    public static void deleteReservation(Reservations reservation){
        try{
            statement.executeUpdate("DELETE FROM booking WHERE booking_id = " + reservation.getTicketNum() + ";");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

}