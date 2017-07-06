package br.ufc.dc.tpi.mytwitter.view;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFX extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml")); 
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("twitter.png")));
		stage.show();
		
		PauseTransition delay = new PauseTransition(Duration.seconds(5));
		delay.setOnFinished( event -> stage.close() );
		delay.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
