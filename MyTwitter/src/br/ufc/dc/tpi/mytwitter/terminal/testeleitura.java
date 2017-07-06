package br.ufc.dc.tpi.mytwitter.terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.RepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.twitter.MyTwitter;

public class testeleitura {
	public static void main(String[] args) {
		try {
			XStream xStream = new XStream(new DomDriver());
			xStream.alias("Tweets", Vector.class);
			xStream.alias("Tweet", Tweet.class);
			//xStream.processAnnotations(PessoaFisica.class);

			BufferedReader input = new BufferedReader(new FileReader("C:/Users/dhann/Documents/Git/MyTwitter/src/br/ufc/dc/tpi/mytwitter/data/tweets/Tweets-dhannyell.xml"));
			Vector<Tweet> vpf = (Vector<Tweet>) xStream.fromXML(input);
			input.close();
			Tweet[] vtw = new Tweet[vpf.size()];
			int i = 0;
			for (Tweet pff : vpf) {
					System.out.println(pff.getMensagem() + "-" + pff.getUsuario());
					vtw[i] = pff;
					i++;
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
