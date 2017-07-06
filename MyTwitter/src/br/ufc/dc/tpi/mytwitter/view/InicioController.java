package br.ufc.dc.tpi.mytwitter.view;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.AmbientLight;
import javafx.scene.layout.AnchorPane;

public class InicioController implements Initializable{
		@FXML
	    private JFXPasswordField senha;

	    @FXML
	    private JFXTextField usuario;

	    @FXML
	    private JFXButton login;

	    @FXML
	    private JFXButton cadastrar;


	    @FXML
	    void makelogin(ActionEvent event) {
	    	String us = usuario.getText();
	    	String pass = senha.getText();
	    	if(us.equals("dhannyell") && pass.equals("123")){
	    		System.out.println("Bem-vindo");
	    	}else{
	    		System.out.println("Senha ou usuario incorreto");
	    	}
	    }


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

	
	
}
