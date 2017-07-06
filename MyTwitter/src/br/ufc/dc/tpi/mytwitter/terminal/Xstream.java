package br.ufc.dc.tpi.mytwitter.terminal;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;

public class Xstream {
	public static void main(String[] args) {
		PessoaFisica p = new PessoaFisica("dhannyell",7042936337L);
		PessoaFisica pp = new PessoaFisica("dhannyell2",7042936337L);
		XStream stream = new XStream(new DomDriver());
		System.out.println(stream.toXML(p) + stream.toXML(pp));
	}
	
	
}
