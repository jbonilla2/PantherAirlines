package databaseAccess;

import Backend.ReservationsTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ReservationsTableData {
		
		private static Statement statement;
	    private static ObservableList<ReservationsTable> reservationsTableItems;
	    private static Connection conn = DBconnect.connect();

	    
	    public static ObservableList<ReservationsTable> getReservationsTableItems() throws ClassNotFoundException, SQLException{
	        
	    	String sql = "SELECT f.DepartingDate, f.DepartingCity, f.ArrivalCity, f.FlightID, r.ticketNumber " +
                    "FROM flight f JOIN reservations r " +
                    "ON f.FlightID = r.FlightID " +
                    "ORDER BY DepartingDate;";
	    	
	    	reservationsTableItems = FXCollections.observableArrayList();

	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(sql);

	            if(rs!=null)
	                while(rs.next()){
	                    
	                	reservationsTableItems.add(new ReservationsTable(rs.getInt(5), rs.getString(2), rs.getString(1), rs.getString(3)));
	                    
	                }
	        }

	        catch(Exception e){
	        	System.out.println("Error occurred while fetching records from the flights database.");
	            e.printStackTrace();
	        }

	        return  reservationsTableItems;
	    }

	

}
