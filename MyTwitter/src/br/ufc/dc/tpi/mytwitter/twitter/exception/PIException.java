package br.ufc.dc.tpi.mytwitter.twitter.exception;

public class PIException extends Exception{
	private String usuario;
	
	public PIException(String usuario) {
		super("Perfil inexistente : ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}
}