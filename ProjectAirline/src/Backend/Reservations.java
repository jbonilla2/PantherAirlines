package Backend;

import javafx.beans.property.*;

public class Reservations {
	
	private IntegerProperty ticketNum, userID, flightID;
    
    public Reservations() {
    	
    	ticketNum = new SimpleIntegerProperty();
        userID = new SimpleIntegerProperty();
        flightID = new SimpleIntegerProperty();
 
    	
    }
    
    public Reservations(int ticketNum, int userID, int flightID) {
        this.ticketNum = new SimpleIntegerProperty(ticketNum);
        this.userID = new SimpleIntegerProperty(userID);
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

    public int getUserID() {
        return userID.get();
    }

    public IntegerProperty userIDProperty() {
        return userID;
    }

    public void setUserID(int userID) {
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
