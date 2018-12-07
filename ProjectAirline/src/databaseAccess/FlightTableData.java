package databaseAccess;

import Backend.FlightTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class FlightTableData {

	 private static Statement statement;
	 private static ObservableList<FlightTable> flightTableItems;
	 private static Connection conn = DBconnect.connect();
	 
	 
	 
	 public static ObservableList<FlightTable> getFlightItems() throws ClassNotFoundException, SQLException{
	     
		 String sql = "SELECT * FROM flight ORDER BY DepartingDate";
		 
		 flightTableItems = FXCollections.observableArrayList();
	        
	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(sql);
	            
	            if(rs!=null)
	                while(rs.next()){
	                    
	                	flightTableItems.add(new FlightTable(rs.getInt(1),rs.getString(2),rs.getString(3),
	                    		rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getInt(8)));
	                }
	        }

	        catch(Exception e){
	        	System.out.println("Error occurred while fetching records from the flights database.");
	            e.printStackTrace();
	        }
	        return  flightTableItems;
	}
	 
	 public static void insertFlight(FlightTable flight)
	    {
	        try{
	            statement.executeUpdate("INSERT INTO flight VALUE(" + flight.getFlightID() + ", " + flight.getDepartingCity() + ", " + flight.getDepartingDate() + ", " + flight.getDepartingTime() + ", " + flight.getArrivalCity() + ", " + flight.getArrivalDate() + ", " + flight.getPrice() + ", " + flight.getSeatsRemaining()+";");
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	 
	 public static void updateFlight(FlightTable flight){
	        try{
	            statement.executeUpdate("UPDATE flight SET FlightID = " + flight.getFlightID()+", DepartingCity = "+flight.getDepartingCity()+", DepartingDate = "+flight.getDepartingDate()+", DepartingTime = "+flight.getDepartingTime()+", ArrivalCity = "+flight.getArrivalCity()+",ArrivalDate = "+flight.getArrivalDate()+",Price = "+flight.getPrice()+",SeatsRemaining = "+flight.getSeatsRemaining()+" WHERE FlightID = "+flight.getFlightID()+ ";");
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	 
	 public static void deleteFlight(FlightTable flight) {		
			
			try{
				statement.executeUpdate("DELETE FROM flight WHERE FlightID = " + flight.getFlightID() + ";");					
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }			
	}
	

	
}
