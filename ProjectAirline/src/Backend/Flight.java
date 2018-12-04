package Backend;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Flight {

    private IntegerProperty flightID, seatsRemaining;
    private StringProperty departingDate, arrivalDate, departingCity, arrivalCity, departingTime;
    private DoubleProperty price;

    
    public Flight() {
    	
    	this.departingDate = new SimpleStringProperty("");
		this.arrivalDate = new SimpleStringProperty("");
        this.departingCity = new SimpleStringProperty("");
        this.arrivalCity = new SimpleStringProperty("");
        this.price = new SimpleDoubleProperty(0);
        this.flightID = new SimpleIntegerProperty(0);
        this.seatsRemaining = new SimpleIntegerProperty(0);
        this.departingTime = new SimpleStringProperty("");
    	
    }
    
    public Flight(String departingDate, String arrivalDate, String departingCity, 
			String arrivalCity, int flightID, int seatsRemaining, double price, String departingTime) {
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

    public int getSeatsRemaining() {
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

