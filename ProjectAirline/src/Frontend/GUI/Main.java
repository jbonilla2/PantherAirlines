package Frontend.GUI;

import java.sql.SQLException;

import org.w3c.dom.Document;

import Frontend.SceneControl.*;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Main extends Application{

	private Pane splashLayout;
	  private ProgressBar loadProgress;
	  private Label progressText;
	  private WebView webView;
	  private Stage mainStage;
	  private static final int SPLASH_WIDTH = 676;
	  private static final int SPLASH_HEIGHT = 227;

	  public static void main(String[] args) throws Exception { launch(args); }

	  @Override public void init() {
	    ImageView splash = new ImageView(new Image("Frontend/GUI/GSU Image.jpg"));
	    //loadProgress = new ProgressBar();
	    //loadProgress.setPrefWidth(SPLASH_WIDTH - 20);
	    progressText = new Label("Loading system with flights . . .");
	    splashLayout = new VBox();
	    
	    splashLayout.getChildren().addAll(splash, progressText);
	    progressText.setAlignment(Pos.CENTER);
	    //splashLayout.setStyle("Frontend/GUI/style.css");
	    splashLayout.setEffect(new DropShadow());
	    
	  }
	  
	  @Override public void start(final Stage initStage) throws Exception {
	    showSplash(initStage);
	    
	    if (initStage.isShowing()) {
		    
		    splashLayout.toFront();
	        FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.0), splashLayout);
	        fadeSplash.setFromValue(1.0);
	        fadeSplash.setToValue(0.5);
	        fadeSplash.setOnFinished(new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent actionEvent) {
	            initStage.close();
	            
	            MainControl.showLoginScene();
	          }
	          
	        });
	        fadeSplash.play();
	    }  
	   	    
	  }

	  private void showMainStage() {
	    
		mainStage = new Stage(StageStyle.DECORATED);
	    mainStage.setTitle("Panther Airlines");
	    mainStage.setIconified(true);
	    
	    Label welLabel = new Label("Hello");
	    
	    // layout the scene.
	    Scene scene = new Scene(welLabel, 1000, 600);
	    mainStage.setScene(scene);
	    
	    mainStage.show();
	    
	    
	  }

	  private void showSplash(Stage initStage) {
	    Scene splashScene = new Scene(splashLayout);
	    initStage.initStyle(StageStyle.UNDECORATED);
	    final Rectangle2D bounds = Screen.getPrimary().getBounds();
	    
	    initStage.setScene(splashScene);
	    initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
	    initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
	    
	    initStage.show();
	  }
	
	
	
	
	
	/*
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);
    	  
    }    
    
    public void start(Stage primaryStage) throws Exception {

        MainControl.showLoginScene();

    }
	*/

}