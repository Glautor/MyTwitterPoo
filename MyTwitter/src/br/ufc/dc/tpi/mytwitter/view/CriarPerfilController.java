package br.ufc.dc.tpi.mytwitter.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;

import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CriarPerfilController implements Initializable {

	@FXML
	private JFXCheckBox PessoaJuridica;

	@FXML
	private AnchorPane anchor;

	@FXML
	private JFXCheckBox PessoaFisica;

	@FXML
	private JFXTextField cpf;

	@FXML
	private JFXButton PerfilBoton;

	@FXML
	private JFXTextField usuario;

	@FXML
	private StackPane pane;

	@FXML
	void criarPerfil(ActionEvent event) {
		Long cpff = Long.parseLong(this.cpf.getText());
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		boolean isSelectPessoaFisica = this.PessoaFisica.isSelected();
		boolean isSelectPessoaJuridica = this.PessoaJuridica.isSelected();
		if (isSelectPessoaFisica == true) {
			br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica p = new br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica(
					usuario.getText(), cpff);
			try {
				my.criarPerfil(p);
			} catch (PEException | UJCException e) {
				// TODO Auto-generated catch block
				JFXDialogLayout content = new JFXDialogLayout();
				content.setHeading(new Text("Erro ao criar perfil"));
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
		} if(isSelectPessoaJuridica == true) {
			br.ufc.dc.tpi.mytwitter.perfil.PessoaJuridica p = new br.ufc.dc.tpi.mytwitter.perfil.PessoaJuridica(
					usuario.getText(), cpff);
			try {
				my.criarPerfil(p);
			} catch (PEException | UJCException e) {
				// TODO Auto-generated catch block
				JFXDialogLayout content = new JFXDialogLayout();
				content.setHeading(new Text("Erro ao criar perfil"));
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
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
