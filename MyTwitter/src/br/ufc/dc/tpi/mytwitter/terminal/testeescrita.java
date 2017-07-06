
package br.ufc.dc.tpi.mytwitter.terminal;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;

public class testeescrita {
     	public static void main(String[] args) throws IOException {
     		Tweet t = new Tweet();
     		t.setMensagem("ssds");
     		t.setUsuario("shdk");
     		Vector<Tweet> vtd = new Vector<Tweet>();
     		vtd.add(t);
     		XStream stream = new XStream(new DomDriver());
     		stream.alias("Tweet", Tweet.class);
     		InputStream is = new FileInputStream("C:/Users/dhann/Documents/Git/MyTwitter/src/br/ufc/dc/tpi/mytwitter/data/tweets/Tweets-dhannyell.xml");
    		BufferedWriter bw =  new BufferedWriter (new FileWriter("C:/Users/dhann/Documents/Git/MyTwitter/src/br/ufc/dc/tpi/mytwitter/data/tweets/Tweets2.xml", true));
    		Scanner entrada = new Scanner(is);
    		for(int i =0;i<1;i++){
    			String linha = entrada.nextLine();
    			String newlinha = linha.substring(1, 6);
    			bw.write(newlinha + stream.toXML(t) + "</Tweets>");
    			bw.newLine();
    		}
    		bw.close();
    		entrada.close();
    	}
    }