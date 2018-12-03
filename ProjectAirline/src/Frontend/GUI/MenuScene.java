package Frontend.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;


public class MenuScene {

    //fields
    private static Scene scene;
    //private static Pane layout;
    private static VBox vbox;
    private static Label quoteLabel, welcomeLabel;
    private static ImageView img;
    private static Button bookingsB, customersB, flightsB, planesB, exitB, logoutB;


    //initialization of objects
    public static void initialize() {

        //quoteLabel
        //quoteLabel = new Label("\"The reason birds can fly and we can't is simply because\n " +
        //        "\t\t\tthey have perfect faith, for to have faith is to have wings..\"");
        //quoteLabel.setId("quote");
        //quoteLabel.relocate(50,520);

        //welcomeLabel
        welcomeLabel = new Label("      Welcome\n\t   to\n Panther Airlines");
        welcomeLabel.setId("welcome");
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setStyle("-fx-font-size: 24pt");
        //welcomeLabel.relocate(810,90);

        /*
        //img
        img = new ImageView("/Presentation/img.png");
        img.setFitHeight(380);
        img.setFitWidth(680);
        img.relocate(30,85);
		*/

        //bookingsB
        bookingsB = new Button("Bookings");
        bookingsB.setAlignment(Pos.CENTER);
        //bookingsB.setDefaultButton(true);
        bookingsB.getStyleClass().add("menu-button");

        //customersB
        customersB = new Button("Customers");
        customersB.setAlignment(Pos.CENTER);
        customersB.getStyleClass().add("menu-button");

        //flightsB
        flightsB = new Button("Flights");
        flightsB.setAlignment(Pos.CENTER);
        flightsB.getStyleClass().add("menu-button");

        //planesB
        planesB = new Button("Planes");
        planesB.setAlignment(Pos.CENTER);
        planesB.getStyleClass().add("menu-button");

        //EXITB
        exitB = new Button("Exit");
        exitB.setId("exit-button");
        exitB.setAlignment(Pos.CENTER);
        
        logoutB = new Button("Log Out");
        logoutB.setId("exit-button");
        logoutB.setAlignment(Pos.CENTER);
        
        //VBox make into layout
        vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(welcomeLabel, bookingsB,customersB,flightsB,planesB,exitB,logoutB);

        //scene
        scene = new Scene(vbox, 800, 800);
        scene.getStylesheets().add("Frontend/GUI/style.css");

        System.out.println("menu scene initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

   /* public static Pane getLayout() {
        return layout;
    }
*/

    public static VBox getVbox() {
        return vbox;
    }

    public static Label getQuoteLabel() {
        return quoteLabel;
    }

    public static Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public static ImageView getImg() {
        return img;
    }

    public static Button getBookingsB() {
        return bookingsB;
    }

    public static Button getCustomersB() {
        return customersB;
    }

    public static Button getFlightsB() {
        return flightsB;
    }

    public static Button getPlanesB() {
        return planesB;
    }

    public static Button getExitB() {
        return exitB;
    }
    
    public static Button getLogoutB() {
        return logoutB;
    }

}
