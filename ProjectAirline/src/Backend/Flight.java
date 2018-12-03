package Backend;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Flight {

    private IntegerProperty flightID, seatsLeft;
    private DoubleProperty price;

    
    public Flight() {
    	
    }
    
    public Flight(int flightID, int seatsLeft, int price) {
        this.flightID = new SimpleIntegerProperty(flightID);
        this.seatsLeft = new SimpleIntegerProperty(seatsLeft);
        this.price = new SimpleDoubleProperty(price);
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
    
    public int getSeatsLeft() {
        return seatsLeft.get();
    }

    public IntegerProperty seatsLeftProperty() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft.set(seatsLeft);
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
    
    

}

