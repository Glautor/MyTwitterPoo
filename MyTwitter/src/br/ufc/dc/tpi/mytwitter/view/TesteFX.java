package br.ufc.dc.tpi.mytwitter.view;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TesteFX extends Application{

	public static void main(String[] args) {
		launch(args);
	}//fim do metodo main
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Image imagem = new Image("br/ufc/dc/tpi/mytwitter/view/twitter.png");
		primaryStage.setTitle("My Twitter");
		primaryStage.getIcons().add(imagem);
		primaryStage.show();
	}

}
