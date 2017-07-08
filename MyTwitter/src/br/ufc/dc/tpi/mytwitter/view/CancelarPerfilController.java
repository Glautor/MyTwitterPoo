package br.ufc.dc.tpi.mytwitter.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UNCException;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CancelarPerfilController implements Initializable {

	@FXML
	private JFXButton cancelar;

	@FXML
	private JFXTextField usuario;

	@FXML
	private StackPane pane;

	@FXML
	void makecancelar(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		try {
			my.cancelarPerfil(usuario.getText());
		} catch (PIException | PDException | UNCException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}