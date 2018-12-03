package Backend;

import javafx.beans.property.*;

public class Reservations {
	
	private IntegerProperty ticketNum, SSN, flightID;
    
    public Reservations() {
    	
    }
    
    public Reservations(int ticketNum, int SSN, int flightID) {
        this.ticketNum = new SimpleIntegerProperty(ticketNum);
        this.SSN = new SimpleIntegerProperty(SSN);
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

    public int getSSN() {
        return SSN.get();
    }

    public IntegerProperty SSNProperty() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN.set(SSN);
    }

    public int getFlightID() {
        return flightID.get();
    }

    public IntegerProperty flightIDProperty() {
        return flightID;
    }

    public void setFlight_id(int flightID) {
        this.flightID.set(flightID);
    }


}
