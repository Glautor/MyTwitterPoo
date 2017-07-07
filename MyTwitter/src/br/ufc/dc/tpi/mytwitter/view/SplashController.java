package br.ufc.dc.tpi.mytwitter.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SplashController implements Initializable{

	    @FXML
	    private StackPane rootPane;
	    

	    @FXML
	    private ProgressIndicator indicador;

	   
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			indicador.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
			new SplashScreen().start();
			
			
		}
		
		class SplashScreen extends Thread{
			public void run(){
				try {
					Thread.sleep(1000);
					
					Platform.runLater(new Runnable() {
						public void run() {
							Parent root = null;
							try {
								root = FXMLLoader.load(getClass().getResource("teste.fxml")); 
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							Scene scene = new Scene(root);
							Stage stage = new Stage();
							stage.setTitle("MyTwitter");
							stage.setScene(scene);
							stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("twitter.png")));
							stage.show();
						}
					});
					
					rootPane.getScene().getWindow().hide();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Logger.getLogger(SplashController.class.getName()).log(Level.SEVERE, null, e);
				}
				
			}
		}

}
