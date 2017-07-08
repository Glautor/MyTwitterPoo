package br.ufc.dc.tpi.mytwitter.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.persistencia.IRepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class EntrarController implements Initializable{

    @FXML
    private JFXButton entrar;

    @FXML
    private JFXTextField usuario;
    
    @FXML
    private StackPane pane;
 

    @FXML
    void makeEntrar(ActionEvent event) {
    	RepositorioUsuario rp = new RepositorioUsuario();
    	Perfil p  = rp.buscar(usuario.getText());
    	if(p!=null){
    		new mytwitter().start();
    	}else{
    		JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro ao tentar entrar"));
			content.setBody(new Text("Usuario não encontrado"));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane, content, JFXDialog.DialogTransition.TOP);
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					dialogo.close();

				}
			});
			content.setActions(button);
			dialogo.show();
    	}
    }

    String pegar_usuario(){
    	return this.usuario.getText();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	class mytwitter extends Thread{
		public void run(){
			Platform.runLater(new Runnable() {
				public void run() {
					Parent root = null;
					try {
						root = FXMLLoader.load(getClass().getResource("MyTwitter.fxml")); 
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
