package Backend;

import javafx.beans.property.*;
import java.util.Date;

public class FlightTable {
	
	private IntegerProperty flightID, seatsLeft;
	private StringProperty departureDate, arrivalDate, departureCity, arrivalCity;
	private DoubleProperty price;
	
	public FlightTable() {
		
	}
	
	public FlightTable(String departureDate) {
		
		this.departureDate = new SimpleStringProperty(departureDate);
		flightID = new SimpleIntegerProperty(0);
		seatsLeft = new SimpleIntegerProperty(0);
		departureCity = new SimpleStringProperty("");
		arrivalCity = new SimpleStringProperty("");
		price = new SimpleDoubleProperty(0);
	
	}
	
	public FlightTable(String departureDate, String arrivalDate, String departureCity, String arrivalCity, int flightID, int seatsLeft, double price) {
		
		this.departureDate = new SimpleStringProperty(departureDate);
		this.arrivalDate = new SimpleStringProperty(arrivalDate);
        this.departureCity = new SimpleStringProperty(departureCity);
        this.arrivalCity = new SimpleStringProperty(arrivalCity);
        this.price = new SimpleDoubleProperty(price);
        this.flightID = new SimpleIntegerProperty(flightID);
        this.seatsLeft = new SimpleIntegerProperty(seatsLeft);
		
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
    
    public String getArrivalDate() {
        return arrivalDate.get();
    }

    public StringProperty arrivalDateProperty() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate.set(arrivalDate);
    }
    
    public String getDepartureCity() {
        return departureCity.get();
    }

    public StringProperty departureCityProperty() {
        return departureCity;
    }

    public void setDeparture_city(String departureCity) {
        this.departureCity.set(departureCity);
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

    public int seatsLeft() {
        return seatsLeft.get();
    }

    public IntegerProperty seatsLeftProperty() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft.set(seatsLeft);
    }

    
	
}
