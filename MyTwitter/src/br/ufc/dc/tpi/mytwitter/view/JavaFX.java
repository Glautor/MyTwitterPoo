package br.ufc.dc.tpi.mytwitter.view;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		
		Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
		Scene scene = new Scene(root);
	
		
		
		
		stage.setScene(scene);
		stage.setTitle("MyTwitter");
		stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("twitter.png")));
		stage.show();
		stage.setResizable(false);
		PauseTransition delay = new PauseTransition(Duration.seconds(1));
		delay.setOnFinished( event -> stage.close() );
		delay.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
