package databaseAccess;

import Backend.ReservationsTable;
import Frontend.SceneControl.LoginSceneControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ReservationsTableData {
		
		private static Statement statement;
	    private static ObservableList<ReservationsTable> reservationsTableItems;
	    private static Connection conn = DBconnect.connect();

	    
	    public static ObservableList<ReservationsTable> getReservationsTableItems() throws ClassNotFoundException, SQLException{
	        
	    	String sql = "SELECT * FROM reservations WHERE " + LoginSceneControl.getUsername() + ";";
	    	
	    	reservationsTableItems = FXCollections.observableArrayList();
	    	
	    	// 

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
	    
	    public static void insertReservation(ReservationsTable table){        
			// this is when the user selects a flight to book
			try{
	            statement.executeUpdate("INSERT INTO reservations VALUE(default, " + .getCustomer_id() + ", " + booking.getFlight_id() + ", '" + booking.getFare_class() + "');");
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }

	

}
