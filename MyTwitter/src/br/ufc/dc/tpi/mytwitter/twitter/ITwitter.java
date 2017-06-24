package br.ufc.dc.tpi.mytwitter.twitter;
import java.util.Vector;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;

public interface ITwitter {
	public void criarPerfil(Perfil usuario) throws UJCException, PEException;
	public void cancelarPerfil(String usuario) throws PIException, PDException;
	public void tweetar(String usuario,String mensagem);
	public Vector<Tweet> tweets(String usuario);
	public Vector<Tweet> timeline(String usuario);
	public void seguir(String seguidor,String seguido);
	public int numeroSeguidores(String usuario);
	public Vector<Perfil> seguidores(String  usuario);
	public Vector<Perfil> seguidos(String usuario);
	}
