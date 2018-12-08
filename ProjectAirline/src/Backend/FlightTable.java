package Backend;

import javafx.beans.property.*;

public class FlightTable {
	
	private IntegerProperty flightID, seatsRemaining;
	private StringProperty departingDate, departingCity, arrivalCity, departingTime;
	private DoubleProperty price;
	
	public FlightTable() {
		
		this.departingDate = new SimpleStringProperty();
		flightID = new SimpleIntegerProperty();
		seatsRemaining = new SimpleIntegerProperty();
		departingCity = new SimpleStringProperty();
		arrivalCity = new SimpleStringProperty();
		price = new SimpleDoubleProperty();
		departingTime = new SimpleStringProperty();
		
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
			String arrivalCity, double price, int seatsRemaining) {
		
		this.flightID = new SimpleIntegerProperty(flightID);
        this.departingCity = new SimpleStringProperty(departingCity);
        this.departingDate = new SimpleStringProperty(departingDate);
        this.departingTime = new SimpleStringProperty(departingTime);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
        this.price = new SimpleDoubleProperty(price);
        this.seatsRemaining = new SimpleIntegerProperty(seatsRemaining);
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
