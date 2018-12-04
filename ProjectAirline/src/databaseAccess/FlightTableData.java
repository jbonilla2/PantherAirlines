package databaseAccess;

import Backend.FlightTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class FlightTableData {

	 private static Statement statement;
	 private static ObservableList<FlightTable> flightTableItems;
	 private static Connection conn = DBconnect.connect();
	 
	 public static ObservableList<FlightTable> getFlightTableItems(){
	        flightTableItems = FXCollections.observableArrayList();
	        
	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT FlightID, DepartingCity, DepartingDate, DepartingTime, ArrivalCity, ArrivalDate, Price, SeatsRemaining " +
	                    "FROM flight ORDER BY DepartingDate;"); 
	            
	            if(rs!=null)
	                while(rs.next()){
	                    FlightTable f = new FlightTable();
	                    
	                    f.setFlightID(rs.getInt(1));
	                    f.setDepartingCity(rs.getString(2));
	                    f.setDepartingDate(rs.getDate(3).toString());
	                    f.setDepartingTime(rs.getString(4));
	                    f.setArrivalCity(rs.getString(5));
	                    f.setArrivalDate(rs.getString(6));                   
	                    f.setPrice(rs.getDouble(7));
	                    f.setSeatsRemaining(rs.getInt(8));

	                    flightTableItems.add(f);
	                }
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }
	        return  flightTableItems;
	    }
	
	 
	 
	
}
