package br.ufc.dc.tpi.mytwitter.terminal;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaJuridica;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UNCException;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;
import br.ufc.dc.tpi.mytwitter.twitter.exception.MFPException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.SIException;
import javafx.*;

public class teste {

	public static void main(String[] args) throws UJCException, UNCException, PEException, PIException, PDException,
			MFPException, SIException, IOException {

		
		PessoaJuridica pj = new PessoaJuridica("dhannyell99", 233283L);
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		//my.tweetar("dhannyell3", "olaaa");
		//my.tweetar("dhannyell3", "a");
		//my.tweetar("dhannyell3", "b");
		//my.tweetar("dhannyell99", "c");
		//my.tweetar("dhannyell3", "teste timeline");
		//my.seguir("dhannyell3", "dhannyell99");
		//my.seguir("dhannyell3", "dhannyell99");
		//my.seguir("dhannyell99", "dhannyell3");
		//my.seguir("dhannyell", "dhannyell3");
		//my.seguir("dhannyell3", "dhannyell99");
		//my.tweetar("dhannyell99", "oio");
		//my.tweetar("dhannyell3", "vc me ver?");
		//my.seguidores("dhannyell3");
		//my.seguidos("dhannyell3");
		for(Tweet t : my.timeline("dhannyell3")){
			System.out.println(t.getMensagem());
		}
		for(Perfil p : my.seguidores("dhannyell3")){
			System.out.println(p.getUsuario());
		};
		
		
		//my.seguidores("dhannyell99");
		//my.timeline("dhannyell3");
		//my.timeline("dhannyell99");
	

	}
}
