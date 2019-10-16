package databaseAccess;

import Backend.FlightTable;
import Backend.ReservationsTable;
import Backend.User;
import Frontend.SceneControl.LoginSceneControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ReservationsTableData {
		
		private static Statement statement;
		private static PreparedStatement pstatement;
	    private static ObservableList<ReservationsTable> reservationsTableItems;
	    private static Connection conn = DBconnect.connect();

	    
	    public static ObservableList<ReservationsTable> getReservationsTableItems() throws ClassNotFoundException, SQLException{
	        
	    	String sql = "SELECT * FROM reservations;";
	    	
	    	reservationsTableItems = FXCollections.observableArrayList();

	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(sql);

	            if(rs!=null)
	                while(rs.next()){
	                    
	                	reservationsTableItems.add(new ReservationsTable(rs.getInt(1), rs.getString(2), rs.getInt(3)));
	                    
	                }
	        }

	        catch(Exception e){
	        	System.out.println("Error occurred while fetching records from the booking database.");
	            e.printStackTrace();
	        }

	        return  reservationsTableItems;
	    }
	    
	    public static ObservableList<ReservationsTable> getReservationsTableItems(String user) throws ClassNotFoundException, SQLException{
	        
	    	String sql = "SELECT * FROM reservations WHERE UserID = '" + user + "';";
	    	
	    	reservationsTableItems = FXCollections.observableArrayList();

	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(sql);

	            if(rs!=null)
	                while(rs.next()){
	                    
	                	reservationsTableItems.add(new ReservationsTable(rs.getInt(1), rs.getString(2), rs.getInt(3)));
	                    
	                }
	        }

	        catch(Exception e){
	        	System.out.println("Error occurred while fetching records from the booking database.");
	            e.printStackTrace();
	        }

	        return  reservationsTableItems;
	    }
	    
	    
	    public static void addReservation(FlightTable flight, String user){        
			// this is when the user selects a flight to book
			
	    	try{
	            String sql = ("INSERT INTO reservations(ticketNumber, UserID, FlightID) VALUES(0, ?, ?);");
	            
	            pstatement = conn.prepareStatement(sql);
	            
	            //pstatement.setInt(1, table.getTicketNum());
	            pstatement.setString(1,  user);
	            pstatement.setInt(2, flight.getFlightID());
	            
	            pstatement.executeUpdate();
	            
	            String sql1 = ("UPDATE flight SET SeatsRemaining = SeatsRemaining - 1 WHERE FlightID = " + 1001 + " AND SeatsRemaining > 0;");
	            
	            
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    	
	    }

	    public static void deleteSeat(int flightID){        
			// this is when the user selects a flight to book
			try{
	            statement.executeUpdate("UPDATE flight SET SeatsRemaining = SeatsRemaining - 1 WHERE FlightID = " + flightID + " AND SeatsRemaining > 0;");
	            
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    	
	    }
	    
	    public static void addSeat(int flightID){        
			// this is when the user selects a flight to book
			try{
	            statement.executeUpdate("UPDATE flight SET SeatsRemaining = SeatsRemaining + 1 WHERE FlightID = " + flightID + " AND SeatsRemaining > 0;");
	            
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    	
	    }
	    
	    
	    public static void deleteReservation(ReservationsTable res) {		
			
			try{
				statement.executeUpdate("DELETE FROM reservations WHERE ticketNumber = " + res.getTicketNum() + ";");					
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }			
	}

}
