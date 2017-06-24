package br.ufc.dc.tpi.mytwitter.persistencia.exception;

public class UJCException extends Exception{
	private static final long serialVersionUID = 1L;
	String usuario;


	public UJCException(String usuario) {
		super("Conta já existente no sistema!");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() + " usuario: " + this.usuario;
	}
}
