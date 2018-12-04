package Backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReservationsTable {
	
	private IntegerProperty ticketNum;
    private StringProperty departingDate, user, route, departingCity, arrivalCity;
    
    public ReservationsTable() {
    	
    }
    
    public ReservationsTable(int ticketNum, String departingCity, String departingDate, String arrivalCity) {
        this.departingCity = new SimpleStringProperty(departingCity);
        this.departingDate = new SimpleStringProperty(departingDate);
        this.ticketNum = new SimpleIntegerProperty(ticketNum);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
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
    
    public String getDepartingDate() {
        return departingDate.get();
    }

    public StringProperty departingDateProperty() {
        return departingDate;
    }

    public void setDepartingDate(String departingDate) {
        this.departingDate.set(departingDate);
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
    
    public String getDepartingCity() {
        return departingCity.get();
    }

    public StringProperty departingCityProperty() {
        return departingCity;
    }

    public void setDepartingCity(String DepartingCity) {
        this.departingCity.set(DepartingCity);
    }
    
    public String getArrivalCity() {
        return arrivalCity.get();
    }

    public StringProperty arrivalCityProperty() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity.set(arrivalCity);
    }
    
    public String toString() {
        return "BookingTable{" +
                "ticketNumber=" + ticketNum +
                ", departingDate=" + departingDate +
                ", route=" + route +
                ", user=" + user +
                '}';
    }


}
