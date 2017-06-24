package br.ufc.dc.tpi.mytwitter.twitter.exception;

public class PDException extends Exception{

	
private String usuario;
	
	public PDException(String usuario) {
		super("Esse usuario está inativo : ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}
}
