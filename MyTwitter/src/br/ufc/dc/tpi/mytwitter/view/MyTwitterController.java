package br.ufc.dc.tpi.mytwitter.view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.print.DocFlavor.READER;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;
import br.ufc.dc.tpi.mytwitter.twitter.exception.MFPException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.SIException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MyTwitterController implements Initializable {

	@FXML
	private JFXButton tweetar;

	@FXML
	private TextFlow caixa;

	@FXML
	private ScrollPane scroll;

	@FXML
	private JFXButton timeline;

	@FXML
	private JFXTextArea caixa_text;

	@FXML
	private Pane pane;

	@FXML
	private JFXTextField u_seguir;

	@FXML
	private JFXButton num_seguidores;

	@FXML
	private JFXButton seguir;

	@FXML
	private Pane pane2;

	@FXML
	private JFXButton tweets;

	@FXML
	private JFXTextField usuario;

	@FXML
	private JFXButton seguidores;

	@FXML
	private JFXListView<String> lista;

	@FXML
	private JFXButton seguidos;
	@FXML
	private StackPane pane3;

	@FXML
	void exibir_tweets(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		Vector<String> y = new Vector<String>();

		try {
			for (Tweet t : my.tweets(usuario.getText())) {
				y.add(t.getMensagem() + "-" + t.getUsuario());
			}
			ObservableList<String> items = FXCollections.observableArrayList(y);
			lista.setItems(items);
		} catch (PIException | PDException e) {
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
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

	@FXML
	void exibir_timeline(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		Vector<String> j = new Vector<String>();

		try {
			for (Tweet t : my.timeline(usuario.getText())) {
				j.add(t.getMensagem() + "-" + t.getUsuario());
			}
			ObservableList<String> items = FXCollections.observableArrayList(j);
			lista.setItems(items);
		} catch (PIException | PDException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
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

	@FXML
	void exibir_seguidores(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		Vector<String> j = new Vector<String>();
		Vector<Perfil> pp = new Vector<Perfil>();
		// pp =
		// my.ler3("src/br/ufc/dc/tpi/mytwitter/data/seguidores/seguidores"+"-"+usuario.getText()+".xml");
		try {
			for (Perfil p : my.seguidores(usuario.getText())) {
				j.add(p.getUsuario());
			}
			ObservableList<String> items = FXCollections.observableArrayList(j);
			lista.setItems(items);
		} catch (PIException | PDException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
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

	@FXML
	void exibir_seguidos(ActionEvent event) throws PDException {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		Vector<String> j = new Vector<String>();
		Vector<Perfil> pp = new Vector<Perfil>();
		// pp =
		// my.ler3("src/br/ufc/dc/tpi/mytwitter/data/seguidos/seguidos"+"-"+usuario.getText()+".xml");
		try {
			for (Perfil p : my.seguidos(usuario.getText())) {
				j.add(p.getUsuario());
			}
		} catch (PIException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					dialogo.close();

				}
			});
			content.setActions(button);
			dialogo.show();
		}
		ObservableList<String> items = FXCollections.observableArrayList(j);
		lista.setItems(items);
	}

	@FXML
	void make_tweetar(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		try {
			my.tweetar(usuario.getText(), caixa_text.getText());

		} catch (PIException | MFPException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
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

	@FXML
	void make_numSeguidores(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		try {
			String num = Integer.toString(my.numeroSeguidores(usuario.getText()));
			ObservableList<String> items = FXCollections.observableArrayList(num);
			lista.setItems(items);
			
		} catch (PIException | PDException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
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

	@FXML
	void make_seguir(ActionEvent event) {
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		try {
			my.seguir(usuario.getText(), u_seguir.getText());
		} catch (PIException | PDException | SIException e) {
			// TODO Auto-generated catch block
			JFXDialogLayout content = new JFXDialogLayout();
			content.setHeading(new Text("Erro"));
			content.setBody(new Text(e.getMessage()));
			JFXButton button = new JFXButton("OK");

			content.setActions(button);
			JFXDialog dialogo = new JFXDialog(pane3, content, JFXDialog.DialogTransition.TOP);
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

	}

}
