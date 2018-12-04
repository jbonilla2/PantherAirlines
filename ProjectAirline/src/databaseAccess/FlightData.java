package databaseAccess;

import Backend.Flight;
import Backend.FlightTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.FileOutputStream;
import java.sql.*;


public class FlightData {

	private static Statement statement;
    private static ObservableList<Flight> flights;
    private static Connection conn = DBconnect.connect();

    
    public static ObservableList<Flight> getFlight() throws ClassNotFoundException, SQLException{
        
    	String sql = "SELECT * FROM flight";
    	flights = FXCollections.observableArrayList();
	
        
        try{
        	statement = conn.createStatement();           
            ResultSet rs = statement.executeQuery(sql);

            if(rs != null)
                while (rs.next()) {
                    Flight flight = new Flight();
                    flight.setFlightID(rs.getInt(1));
                    flight.setDepartingCity(rs.getString(2));
                    flight.setDepartingDate(rs.getString(3));
                    flight.setDepartingTime(rs.getString(4));
                    flight.setArrivalCity(rs.getString(5));
                    flight.setArrivalDate(rs.getString(6));                   
                    flight.setPrice(rs.getDouble(7));
                    flight.setSeatsRemaining(rs.getInt(8));              
                    
                    flights.add(flight);
                }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return flights;
    }


    public static void insertFlight(FlightTable flight) {
        
    	try{
            statement.executeUpdate("INSERT INTO flight VALUE(default, " + flight.getDepartingCity() + ", " + flight.getDepartingDate() + ", " + flight.getDepartingTime() + ", " + flight.getArrivalCity() + ", " + flight.getArrivalDate() + ", " + flight.getPrice() + ", " + flight.seatsRemaining() +");");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void updateFlight(Flight flight){
        
    	try{
            statement.executeUpdate("UPDATE flight SET FlightID = " + flight.getFlightID() + ", DepartingCity = " + flight.getDepartingCity() + ", DepartingDate = " + flight.getDepartingDate() + ", DepartingTime = " + flight.getDepartingTime()+", ArrivalCity = "+flight.getArrivalCity() + ", ArrivalDate = "+flight.getArrivalDate() + ", price = " +  flight.getPrice() + ", SeatsRemaining = " + flight.getSeatsRemaining() + ", WHERE flightID = " + flight.getFlightID() + ";");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void deleteFlight(Flight flight){
        
    	try{
            statement.executeUpdate("DELETE FROM flight WHERE flightID = " + flight.getFlightID() + ";");
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
        
        
}
