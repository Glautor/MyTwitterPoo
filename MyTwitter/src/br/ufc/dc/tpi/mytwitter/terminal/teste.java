package br.ufc.dc.tpi.mytwitter.terminal;
import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
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

public class teste {

	public static void main(String[] args) throws UJCException, UNCException, PEException, PIException, PDException, MFPException, SIException{
		PessoaFisica pf = new PessoaFisica("dhannyell");
		PessoaFisica pff = new PessoaFisica("dhannyell2");
		PessoaFisica pfff = new PessoaFisica("dhannyell3");
		RepositorioUsuario rp = new RepositorioUsuario();
		MyTwitter my = new MyTwitter(rp);
		my.criarPerfil(pf);
		my.criarPerfil(pff);
		my.criarPerfil(pfff);
		my.seguir("dhannyell", "dhannyell2");
		my.seguir("dhannyell", "dhannyell3");
		//my.cancelarPerfil("dhannyell");
		my.numeroSeguidores("dhannyel2");
		my.cancelarPerfil("dhannyell4");
		
		
		
	}
}
