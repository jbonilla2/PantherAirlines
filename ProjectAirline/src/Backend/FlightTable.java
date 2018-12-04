package Backend;

import javafx.beans.property.*;
import java.util.Date;

public class FlightTable {
	
	private IntegerProperty flightID, seatsRemaining;
	private StringProperty departingDate, arrivalDate, departingCity, arrivalCity, departingTime;
	private DoubleProperty price;
	
	public FlightTable() {
		
	}
	
	public FlightTable(String departingDate) {
		
		this.departingDate = new SimpleStringProperty(departingDate);
		flightID = new SimpleIntegerProperty(0);
		seatsRemaining = new SimpleIntegerProperty(0);
		departingCity = new SimpleStringProperty("");
		arrivalCity = new SimpleStringProperty("");
		price = new SimpleDoubleProperty(0);
		departingTime = new SimpleStringProperty("");
	
	}
	
	public FlightTable(int flightID, String departingCity, String departingDate, String departingTime,  
			String arrivalCity, String arrivalDate, double price, int seatsRemaining) {
		
		this.departingDate = new SimpleStringProperty(departingDate);
		this.arrivalDate = new SimpleStringProperty(arrivalDate);
        this.departingCity = new SimpleStringProperty(departingCity);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
        this.price = new SimpleDoubleProperty(price);
        this.flightID = new SimpleIntegerProperty(flightID);
        this.seatsRemaining = new SimpleIntegerProperty(seatsRemaining);
        this.departingTime = new SimpleStringProperty(departingTime);
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
    
    public String getArrivalDate() {
        return arrivalDate.get();
    }

    public StringProperty arrivalDateProperty() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate.set(arrivalDate);
    }
    
    public String getDepartingCity() {
        return departingCity.get();
    }

    public StringProperty departingCityProperty() {
        return departingCity;
    }

    public void setDepartingCity(String departingCity) {
        this.departingCity.set(departingCity);
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
    
    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
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

    public int seatsRemaining() {
        return seatsRemaining.get();
    }

    public IntegerProperty seatsRemainingProperty() {
        return seatsRemaining;
    }

    public void setSeatsRemaining(int seatsRemaining) {
        this.seatsRemaining.set(seatsRemaining);
    }

    public String getDepartingTime() {
        return departingTime.get();
    }

    public StringProperty departingTimeProperty() {
        return departingTime;
    }

    public void setDepartingTime(String departingTime) {
        this.departingTime.set(departingTime);
    }
	
}
