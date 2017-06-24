package br.ufc.dc.tpi.mytwitter.persistencia;
import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UNCException;

public interface IRepositorioUsuario {

	public void cadastrar(Perfil usuario) throws UJCException;
	public Perfil buscar(String usuario);
	public void atualizar(Perfil usuario) throws UNCException;
	
}
