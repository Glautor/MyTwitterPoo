package br.ufc.dc.tpi.mytwitter.perfil;
public class PessoaFisica extends Perfil {
	private long cpf = 0;
	
	public PessoaFisica(String usuario,long cpf){
		super(usuario);
		this.cpf = cpf;
	}
	
	public void setCpf(long cpf){
		this.cpf = cpf;
	}
	
	public long getCpf(){
		return this.cpf;
	}
	
	
}
