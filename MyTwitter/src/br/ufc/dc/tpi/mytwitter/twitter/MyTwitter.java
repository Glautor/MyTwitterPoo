package br.ufc.dc.tpi.mytwitter.twitter;
import java.util.Vector;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.IRepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;


public class MyTwitter implements ITwitter{
	private IRepositorioUsuario repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio){
		this.repositorio = repositorio;
	}
	
	@Override
	public void criarPerfil(Perfil usuario) throws PEException, UJCException{
		if(repositorio.buscar(usuario.getUsuario()) == null){
			repositorio.cadastrar(usuario);
		}else{
			throw new PEException(usuario.getUsuario());
		}
		
	}

		
	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		if(p != null && p.isAtivo() == true){
			p.setAtivo(false);
		}if(p == null){
			throw new PIException(usuario);
		}if(p != null && p.isAtivo() == false){
			throw new PDException(usuario);
		}

		
	}

	@Override
	public void tweetar(String usuario, String mensagem) {
		
	}

	@Override
	public Vector<Tweet> tweets(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Tweet> timeline(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seguir(String seguidor, String seguido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int numeroSeguidores(String usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
