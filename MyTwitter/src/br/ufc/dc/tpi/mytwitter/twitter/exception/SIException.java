package br.ufc.dc.tpi.mytwitter.twitter.exception;

public class SIException extends Exception {
	private static final long serialVersionUID = 1L;

	public SIException() {
		super("Perfil do seguidor é igual ao do seguido. ");
		//this.usuario = usuario;
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
