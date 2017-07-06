package br.ufc.dc.tpi.mytwitter.twitter.exception;

public class MFPException extends Exception{

	private static final long serialVersionUID = 1L;

	public MFPException() {
		super("Mensagem possui mais caracteres que os 140 permitidos");
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
