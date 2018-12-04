package Frontend.GUI;

//Change the red, add or change Table columns

import Backend.FlightTable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ViewFlightsScene {

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
    private static Pane layout;
    private static Scene scene;
   
    private static TableView<FlightTable> table;
    private static TableColumn<FlightTable, Integer> flightIDColumn, seatsRemainingColumn;
    private static TableColumn<FlightTable, String> departingCityColumn, departingDateColumn, departingTimeColumn, arrivalCityColumn, arrivalDateColumn;
    private static TableColumn<FlightTable, Double> priceColumn;
    
    private static TextField search;
    private static HBox buttonLayout;
    private static Button backB, addB, editB, deleteFlightsB;


    //initialization of objects
    public static void initialize() {

        //table
        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setMinSize(1116,591);
        table.relocate(42,32);

        //initialize columns
        flightIDColumn = new TableColumn<>("ID");
        flightIDColumn.setCellValueFactory(cellData -> cellData.getValue().flightIDProperty().asObject());

        departingDateColumn = new TableColumn<>("Departing date");
        departingDateColumn.setCellValueFactory(cellData -> cellData.getValue().departingDateProperty());

        departingCityColumn = new TableColumn<>("Departing city");
        departingCityColumn.setCellValueFactory(cellData -> cellData.getValue().departingCityProperty());

        departingTimeColumn = new TableColumn<>("Departing time");
        departingTimeColumn.setCellValueFactory(cellData -> cellData.getValue().departingTimeProperty());
        
        arrivalCityColumn = new TableColumn<>("Arrival city");
        arrivalCityColumn.setCellValueFactory(cellData -> cellData.getValue().arrivalCityProperty());

        arrivalDateColumn = new TableColumn<>("Arrival Date");
        arrivalDateColumn.setCellValueFactory(cellData -> cellData.getValue().arrivalDateProperty());

        priceColumn = new TableColumn<>("Basic price");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        seatsRemainingColumn = new TableColumn<>("Available seats");
        seatsRemainingColumn.setCellValueFactory(cellData -> cellData.getValue().seatsRemainingProperty().asObject());

        table.getColumns().addAll(flightIDColumn, departingCityColumn, departingDateColumn, departingTimeColumn, arrivalCityColumn, arrivalDateColumn, priceColumn, seatsRemainingColumn);

        //search field
        search = new TextField();
        search.setPromptText("search");
        search.setMinWidth(545);
        search.relocate(42,642);

        //back butt
        backB = new Button("Back");

        //add butt
        addB = new Button("Add...");

        //edit butt
        editB = new Button("Edit...");

        //exportFlightsB
        deleteFlightsB = new Button("Delete");

        //button layout
        buttonLayout = new HBox(20);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.relocate(740,642);
        buttonLayout.getChildren().addAll(addB,editB,deleteFlightsB,backB);

        //layout setup
        layout = new Pane();
        layout.getChildren().addAll(table,search,buttonLayout);

        //scene
        scene = new Scene(layout, 1200, 700);
        scene.getStylesheets().add("/Frontend/GUI/style.css");

        System.out.println("flights scene initialized");
    }


    //getters
    public static Pane getLayout() {
        return layout;
    }

    public static Scene getScene() {
        return scene;
    }

    public static TableView<FlightTable> getTable() {
        return table;
    }

    public static TableColumn<FlightTable, Integer> getFlightIDColumn() {
        return flightIDColumn;
    }

    public static TableColumn<FlightTable, Integer> getSeatsRemainingColumn() {
        return seatsRemainingColumn;
    }

    public static TableColumn<FlightTable, String> getDepartingDateColumn() {
        return departingDateColumn;
    }

    public static TableColumn<FlightTable, String> getDepartingCityColumn() {
        return departingCityColumn;
    }

    public static TableColumn<FlightTable, String> getArrivalCityColumn() {
        return arrivalCityColumn;
    }
    
    public static TableColumn<FlightTable, String> getDepartingTimeColumn() {
		return departingTimeColumn;
	}

	public static TableColumn<FlightTable, String> getArrivalDateColumn() {
		return arrivalDateColumn;
	}

    public static TableColumn<FlightTable, Double> getPriceColumn() {
        return priceColumn;
    }

    public static TextField getSearch() {
        return search;
    }

    public static HBox getButtonLayout() {
        return buttonLayout;
    }

    public static Button getBackB() {
        return backB;
    }

    public static Button getAddB() {
        return addB;
    }

    public static Button getEditB() {
        return editB;
    }

    public static Button getDeleteFlightsB() {
        return deleteFlightsB;
    }

}

