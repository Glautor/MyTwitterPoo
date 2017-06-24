package br.ufc.dc.tpi.mytwitter.persistencia.exception;

public class UNCException extends Exception{

	private static final long serialVersionUID = 1L;
	private String usuario;

	public UNCException(String usuario) {
		super("Não foi possivel atualizar, usuario não existente: ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}

}
