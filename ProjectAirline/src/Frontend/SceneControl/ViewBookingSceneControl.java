package Frontend.SceneControl;

import Backend.*;
import databaseAccess.*;
import Frontend.GUI.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.sql.SQLException;

public class ViewBookingSceneControl {

    private static TableView<ReservationsTable> table;
    private static ObservableList<ReservationsTable> reservations, tableItems;  
    
    private static TextField search;
    private static Button add_bookingButton;
    private static Button backButton;
    
    
    public static void initialize() {

    	table = ViewBookingScene.getTable();
        try {
			table.setItems(ReservationsTableData.getReservationsTableItems());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        add_bookingButton = ViewBookingScene.getAdd_bookingButton();
        add_bookingButton.setOnAction(e -> handle_addButton());

        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());

        search = ViewBookingScene.getSearchField();
        reservations = table.getItems();
        initializeSearch();
    }

    public static void handle_backButton() {
        MainControl.showMenuScene();
    }


    public static void handle_addButton(){
    	MainControl.showFlightEditScene();
    	System.out.println("new booking added");

    }


   public static void initializeSearch() {
        search.textProperty().addListener(new InvalidationListener() {
           
        	@Override
            public void invalidated(Observable observable) {
                if (search.textProperty().get().isEmpty()) {
                    table.setItems(reservations);
                    return;
                }

                tableItems = FXCollections.observableArrayList();

                for(ReservationsTable b : reservations){
                    if(b.getFlightID() == Integer.parseInt(search.getText())||
                            b.getTicketNum() == Integer.parseInt(search.getText())) {

                        tableItems.add(b);
                    }
                }

                table.setItems(tableItems);
            }
        });
   }

}
