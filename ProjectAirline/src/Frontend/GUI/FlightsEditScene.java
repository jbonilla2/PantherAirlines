package Frontend.GUI;

import Frontend.SceneControl.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Arc2D;

public class FlightsEditScene {

/* To DO: 
 * delete route
 * need FlightID
 * Departing City which is only ATL
 * Departing Date
 * Departing time  and delete arrival time
 * Arrival City
 * Arrival Date
 * Price
 * Seats remaining 	
 */
    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static Pane layout;
    private static Label flightL,timeL,dcityL,acityL,depdateL,arrivdateL,fidL,priceL,seatsL;
    private static ComboBox<String> dcityC, acityC, departure_time;
    private static DatePicker departure_date, arrival_date;
    private static TextField flight_id, price, seatsT;
    private static Button addB,editB, cancelB;
    private static VBox vBox1, vBox2;

    private static HBox buttons;


    //initialization of objects
    public static void initialize(){

        //labels
        flightL = new Label("Flight details");
        flightL.relocate(190,10);
        flightL.setAlignment(Pos.CENTER);
        flightL.setStyle("-fx-font-size:20pt");

        dcityL = new Label("Departing City");
        acityL = new Label("Arrival City");
        depdateL = new Label("Departing Date");
        //arrivdateL = new Label("Arrival Date");
        timeL = new Label("Departing Time");
        fidL = new Label ("Flight ID");
        priceL = new Label("Base price");
        seatsL = new Label("Remaining Seats");


        //labels layout
        vBox1 = new VBox();
        vBox1.getChildren().addAll(dcityL, acityL, depdateL, timeL,fidL, priceL, seatsL);
        //vBox1.getChildren().addAll(dcityL, acityL, depdateL, arrivdateL, timeL,fidL, priceL, seatsL);
        vBox1.relocate(20,55);
        vBox1.setSpacing(36);

        //combo boxes
        dcityC = new ComboBox<>();
        dcityC.setMinWidth(248);
        
        acityC = new ComboBox<>();
        acityC.setMinWidth(248);
        
        departure_time = new ComboBox<>();
        
        //flight id field
        flight_id = new TextField();

        //price field
        price = new TextField();

        //input remaining seats
        seatsT = new TextField();

        //departure date picker
        departure_date = new DatePicker();
        departure_date.setMinWidth(248);
        
        //arrival date picker
       // arrival_date = new DatePicker();
       // arrival_date.setMinWidth(248);
        
        //buttons
        addB = new Button("Add");
        addB.setDefaultButton(true);

        editB = new Button("Edit");
        editB.setDefaultButton(true);
        
        cancelB = new Button("Cancel");

        buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(addB, editB, cancelB);

        //selectors layout
        vBox2 = new VBox();
       // vBox2.getChildren().addAll(dcityC, acityC,departure_date,arrival_date,departure_time,flight_id, price, seatsT, buttons);
        vBox2.getChildren().addAll(dcityC, acityC,departure_date,departure_time,flight_id, price, seatsT, buttons);
        vBox2.setSpacing(24);
        vBox2.relocate(170,50);


        //layout
        layout = new Pane();
        layout.getChildren().addAll(flightL, vBox1, vBox2);
        layout.getStylesheets().add("/Frontend/GUI/style.css");
        
        //stage setup
        scene = new Scene(layout,500,450);
        scene.getStylesheets().addAll("/Frontend/GUI/style.css");

        dialogStage = new Stage();
        dialogStage.setScene(scene);

        System.out.println("flight edit dialog initialized");
    }



    public static TextField getSeatsT() {
		return seatsT;
	}



	//getters
    public static Stage getDialogStage() {
        return dialogStage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Label getFlightL() {
        return flightL;
    }

    public static Label getTimeL() {
        return timeL;
    }

    public static Label getDcityL() {
        return dcityL;
    }

    public static Label getPriceL() {
        return priceL;
    }

       public static ComboBox<String> getDeparture_time() {
        return departure_time;
    }

    public static DatePicker getDeparture_date() {
        return departure_date;
    }

    public static TextField getPrice() {
        return price;
    }

    public static Button getAddB() {
        return addB;
    }

    public static Button getEditB() {
        return editB;
    }
    
    public static Button getCancelB() {
        return cancelB;
    }

    public static VBox getvBox1() {
        return vBox1;
    }

    public static VBox getvBox2() {
        return vBox2;
    }



	public static Label getAcityL() {
		return acityL;
	}



	public static Label getDepdateL() {
		return depdateL;
	}



	public static Label getArrivdateL() {
		return arrivdateL;
	}



	public static Label getFidL() {
		return fidL;
	}



	public static Label getSeatsL() {
		return seatsL;
	}



	public static ComboBox<String> getDcityC() {
		return dcityC;
	}



	public static ComboBox<String> getAcityC() {
		return acityC;
	}



	public static DatePicker getArrival_date() {
		return arrival_date;
	}



	public static TextField getFlight_id() {
		return flight_id;
	}



	public static HBox getButtons() {
		return buttons;
	}

}
