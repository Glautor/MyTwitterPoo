package br.ufc.dc.tpi.mytwitter.terminal;
import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UNCException;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;

public class teste {

	public static void main(String[] args) throws UJCException, UNCException, PEException, PIException, PDException{
		PessoaFisica pf = new PessoaFisica("dhannyell");
		PessoaFisica pff = new PessoaFisica("dhannyell2");
		PessoaFisica pfff = new PessoaFisica("dhannyell3");
		// System.out.println(pf.getUsuario());
		 RepositorioUsuario rp = new RepositorioUsuario();
		 //rp.cadastrar(pff);
		// System.out.println(rp.tamanho());
		// rp.cadastrar(pf);
		// rp.cadastrar(pff);
		// System.out.println(rp.buscar("dhannyell"));
		// System.out.println(rp.tamanho());
		// for(int i=0;i<rp.tamanho();i++){
		// System.out.println(rp.listar());
		// }
		// }
		
		MyTwitter my = new MyTwitter(rp);
		my.criarPerfil(pf);
		//my.cancelarPerfil("dhannyell");
		System.out.println(pf.isAtivo());
		//my.cancelarPerfil("dhannyell");
		my.cancelarPerfil("kaline");
	
	
	}
}
