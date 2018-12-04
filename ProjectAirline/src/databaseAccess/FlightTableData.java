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
	     
		 String sql = "SELECT FlightID, DepartingCity, DepartingDate, DepartingTime, ArrivalCity, ArrivalDate, Price, SeatsRemaining " +
                 "FROM flight ORDER BY DepartingDate";
		 
		 flightTableItems = FXCollections.observableArrayList();
	        
	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(sql); 
	            //ObservableList<FlightTable> fList = null;
	            
	            if(rs!=null)
	                while(rs.next()){
	                    //FlightTable f = new FlightTable();
	                	flightTableItems.add(new FlightTable(rs.getInt(1),rs.getString(2),rs.getString(3),
	                    		rs.getString(4),rs.getString(5),rs.getString(6),rs.getDouble(7),rs.getInt(8)));
	                    /*f.setDepartingCity(rs.getString(2));
	                    f.setDepartingDate(rs.getString(3));
	                    f.setDepartingTime(rs.getString(4));
	                    f.setArrivalCity(rs.getString(5));
	                    f.setArrivalDate(rs.getString(6));                   
	                    f.setPrice(rs.getDouble(7));
	                    f.setSeatsRemaining(rs.getInt(8));
						
	                    flightTableItems.add(f);
	                    */
	                }
	        }

	        catch(Exception e){
	        	System.out.println("Error occurred while fetching records from the flights database.");
	            e.printStackTrace();
	        }
	        return  flightTableItems;
	}

	 
/*public static ObservableList<FlightTable> getFlightItems(ResultSet rs) throws ClassNotFoundException, SQLException{
		 
		 flightTableItems = FXCollections.observableArrayList(); // delete or not?
	        
	        try{
	            statement = conn.createStatement();           
	            ObservableList<FlightTable> fTable =  FXCollections.observableArrayList();
	            
	            if(rs!=null)
	                while(rs.next()){
	              //     FlightTable f = new FlightTable();
	                	FlightTable fTable1 = new FlightTable();
	                	fTable1.setFlightID(rs.getInt(1));
	                	fTable1.setDepartingCity(rs.getString(2));
	                	fTable1.setDepartingDate(rs.getString(3));
	                	fTable1.setDepartingTime(rs.getString(4));
	                	fTable1.setArrivalCity(rs.getString(5));
	                	fTable1.setArrivalDate(rs.getString(6));                   
	                	fTable1.setPrice(rs.getDouble(7));
	                	fTable1.setSeatsRemaining(rs.getInt(8));

	                    flightTableItems.add(f);
	                }
	        }

	        catch(Exception e){
	        	System.out.println("Error occurred while fetching records from the flights database.");
	            e.printStackTrace();
	        }
	        return  flightTableItems;
	}
	
	*/ 

	
}
