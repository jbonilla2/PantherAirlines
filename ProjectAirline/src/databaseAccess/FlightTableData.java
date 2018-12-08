package databaseAccess;

import Backend.FlightTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class FlightTableData {

	 private static Statement statement;
	 private static PreparedStatement pstatement;
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
	                    		rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7)));
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
	            //statement.executeUpdate("INSERT INTO flight VALUE(" + flight.getFlightID() + ", " + flight.getDepartingCity() + ", " + flight.getDepartingDate() + ", " + flight.getDepartingTime() + ", " + flight.getArrivalCity() + ", " + flight.getArrivalDate() + ", " + flight.getPrice() + ", " + flight.getSeatsRemaining()+";");
	        
	        	String qry = "INSERT INTO flight" +
	        			"(FlightID, DepartingCity, DepartingDate, DepartingTime, ArrivalCity, Price, SeatsRemaining)" + 
	        			"VALUES(?, ?, ?, ?, ?, ?, ?)";
	            
	        	pstatement = conn.prepareStatement(qry);
	            
	            pstatement.setInt(1, flight.getFlightID());
	            pstatement.setString(2, flight.getDepartingCity());
	            pstatement.setString(3, flight.getDepartingDate());
	            pstatement.setString(4, flight.getDepartingTime());
	            pstatement.setString(5, flight.getArrivalCity());
	            pstatement.setDouble(6, flight.getPrice());
	            pstatement.setInt(7, flight.getSeatsRemaining());
	            
	            pstatement.executeUpdate();
	        	
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	 
	 public static void updateFlight(FlightTable flight){
	        try{

	            String sql = ("UPDATE flight SET DepartingCity = ?, DepartingDate = ?," 
	            		+ "DepartingTime = ?, ArrivalCity = ?, Price = ?, SeatsRemaining = ? WHERE FlightID = ?;");
	        
	        pstatement = conn.prepareStatement(sql);
	        pstatement.setString(1, flight.getDepartingCity());
	        pstatement.setString(2, flight.getDepartingDate());
	        pstatement.setString(3, flight.getDepartingTime());
	        pstatement.setString(4, flight.getArrivalCity());
	        pstatement.setDouble(5, flight.getPrice());
	        pstatement.setInt(6, flight.getSeatsRemaining());
	        pstatement.setInt(7, flight.getFlightID());
	        pstatement.executeUpdate();        

	         //   statement.executeUpdate("UPDATE flight SET FlightID = " + flight.getFlightID()+", DepartingCity = "+flight.getDepartingCity()+", DepartingDate = "+flight.getDepartingDate()+", DepartingTime = "+flight.getDepartingTime()+", ArrivalCity = "+flight.getArrivalCity()+ ", Price = "+flight.getPrice()+ ", SeatsRemaining = " +flight.getSeatsRemaining()+ " WHERE FlightID = "+flight.getFlightID()+ ";");

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
	
	 public static void deleteFlight(int row) {		
			
		 row = row -1;
		 	
		 try{
			 statement.executeUpdate("DELETE FROM flight WHERE rowIndex = " + row + ";");					
		 }	
		 catch(Exception e){
			 e.printStackTrace();
		 }			
	 }

	
}
