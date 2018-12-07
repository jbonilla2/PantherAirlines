package Backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReservationsTable {
	
	private IntegerProperty ticketNum, flightID;
    private StringProperty userID;
    
    public ReservationsTable() {
    	
    }
    
    public ReservationsTable(int ticketNum, String userID, int flightID) {
        this.userID = new SimpleStringProperty(userID);
        this.ticketNum = new SimpleIntegerProperty(ticketNum);
        this.flightID = new SimpleIntegerProperty(flightID);
    }
    
    public int getTicketNum() {
        return ticketNum.get();
    }

    public IntegerProperty ticketNumProperty() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum.set(ticketNum);
    }
    
    public String getUserID() {
        return userID.get();
    }

    public StringProperty userIDProperty() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }

    public IntegerProperty flightIDProperty() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID.set(flightID);
    }
    
    public int getFlightID() {
        return flightID.get();
    }

    
    public String toString() {
        return "ReservationsTable{" +
                "ticketNumber=" + ticketNum +
                '}';
    }


}
