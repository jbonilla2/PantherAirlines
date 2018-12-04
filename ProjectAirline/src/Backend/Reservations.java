package Backend;

import javafx.beans.property.*;

public class Reservations {
	
	private IntegerProperty ticketNum, flightID;
	private StringProperty userID;
    
    public Reservations() {
    	
    	ticketNum = new SimpleIntegerProperty();
        userID = new SimpleStringProperty();
        flightID = new SimpleIntegerProperty();
 
    	
    }
    
    public Reservations(int ticketNum, String userID, int flightID) {
        this.ticketNum = new SimpleIntegerProperty(ticketNum);
        this.userID = new SimpleStringProperty(userID);
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

    public int getFlightID() {
        return flightID.get();
    }

    public IntegerProperty flightIDProperty() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID.set(flightID);
    }
    
    @Override
    public String toString() {
        return "Reservation{" +
                "ticketNumber =" + ticketNum +
                ", UserID =" + userID +
                ", FlightID=" + flightID +
                '}';
    }


}
