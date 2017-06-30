package br.ufc.dc.tpi.mytwitter.twitter;
import java.util.Vector;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.MFPException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.SIException;

public interface ITwitter {
	public void criarPerfil(Perfil usuario) throws UJCException, PEException;
	public void cancelarPerfil(String usuario) throws PIException, PDException;
	public void tweetar(String usuario,String mensagem) throws PIException, MFPException;
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException;
	public void seguir(String seguidor,String seguido) throws PIException, PDException, SIException;
	public int numeroSeguidores(String usuario) throws PIException, PDException;
	public Vector<Perfil> seguidores(String  usuario) throws PIException, PDException;
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException;
	}
