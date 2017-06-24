package br.ufc.dc.tpi.mytwitter.twitter.exception;

public class PEException extends Exception{

	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PEException(String usuario) {
		super("Não foi possivel criar perfil, usuario já existente: ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}

	
	
	
	
}
