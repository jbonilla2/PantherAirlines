package databaseAccess;

import Backend.ReservationsTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ReservationsTableData {
		
		private static Statement statement;
	    private static ObservableList<ReservationsTable> reservationsTableItems;
	    private static Connection conn = DBconnect.connect();

	    
	    public static ObservableList<ReservationsTable> getReservationsTableItems() {
	        reservationsTableItems = FXCollections.observableArrayList();

	        try{
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT f.DepartingDate, f.DepartingCity, f.ArrivalCity, f.FlightID, r.ticketNumber " +
	                    "FROM flight f JOIN reservations r " +
	                    "ON f.FlightID = r.FlightID " +
	                    "ORDER BY DepartingDate;");

	            if(rs!=null)
	                while(rs.next()){
	                    ReservationsTable b = new ReservationsTable();
	                    b.setDepartingDate(rs.getDate(1).toString());
	                    b.setDepartingCity(rs.getString(2));
	                    b.setArrivalCity(rs.getString(4));
	                    b.setTicketNum(rs.getInt(5));

	                    reservationsTableItems.add(b);
	                }
	        }

	        catch(Exception e){
	            e.printStackTrace();
	        }

	        return  reservationsTableItems;
	    }

	

}
