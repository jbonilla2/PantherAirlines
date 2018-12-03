package Backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReservationsTable {
	
	private IntegerProperty ticketNum;
    private StringProperty departureDate, user;
    
    public ReservationsTable() {
    	
    }
    
    public ReservationsTable(int ticketNum, String departureDate, String user) {
        this.ticketNum = new SimpleIntegerProperty(ticketNum);
        this.departureDate = new SimpleStringProperty(departureDate);
        this.user = new SimpleStringProperty(user);
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
    
    public String getDepartureDate() {
        return departureDate.get();
    }

    public StringProperty departureDateProperty() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate.set(departureDate);
    }
    
    public String getUser() {
        return user.get();
    }

    public StringProperty userProperty() {
        return user;
    }

    public void setUser(String user) {
        this.user.set(user);
    }
    
    public String toString() {
        return "BookingTable{" +
                "ticketNumber=" + ticketNum +
                ", departureDate=" + departureDate +
                ", user=" + user +
                '}';
    }


}
