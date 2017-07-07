package br.ufc.dc.tpi.mytwitter.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class TesteController implements Initializable{

    @FXML
    private JFXButton criar_perfil;

    @FXML
    private JFXButton entrar;

    @FXML
    void criarPerfil(ActionEvent event) {
    	new perfil().start();
    }

    @FXML
    void ad24d0(ActionEvent event) {

    }

    @FXML
    void entrar(ActionEvent event) {
    	new Entrar().start();
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	class perfil extends Thread{
		public void run(){
			Platform.runLater(new Runnable() {
				public void run() {
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("CriarPerfil.fxml")); 
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setResizable(false);
					stage.setTitle("MyTwitter");
					stage.setScene(scene);
					stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("twitter.png")));
					stage.show();
				}
			});
			
		}
	}
	
	class Entrar extends Thread{
		public void run(){
			Platform.runLater(new Runnable() {
				public void run() {
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("Entrar.fxml")); 
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setResizable(false);
					stage.setTitle("MyTwitter");
					stage.setScene(scene);
					stage.getIcons().add(new Image(JavaFX.class.getResourceAsStream("twitter.png")));
					stage.show();
				}
			});
			
		}
	}

}