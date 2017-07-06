package br.ufc.dc.tpi.mytwitter.perfil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

@XStreamAlias("Perfil")
public abstract class Perfil {
	private String usuario;
	private Vector<Perfil> seguidos;
	private Vector<Perfil> seguidores;
	private Vector<Tweet> timeline;
	private boolean ativo;
	
	public Perfil(String usuario){
		
		this.seguidos = new Vector<Perfil>();
		this.seguidores = new Vector<Perfil>();
		this.timeline = new Vector<Tweet>();
		this.usuario = usuario;
		this.ativo = true;
	}
	
	public void addSeguido(Perfil usuario){
		this.seguidos.add(usuario);
	}
	
	public void addSeguidor(Perfil usuario){
		this.seguidores.add(usuario);
	}
	
	public void addTweet(Tweet tweet){
		this.timeline.add(tweet);
	}
	
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	
	public String getUsuario(){
		return this.usuario;
		
	}
	
	public Perfil[] getSeguidos(){
		Perfil array[] = new Perfil[this.seguidos.size()];
		int index = 0;
		for(Perfil s : seguidos ){
			array[index++] = s;
		}
		return array;
	}
	
	public Perfil[] getSeguidores(){
		Perfil array[] = new Perfil[this.seguidores.size()];
		int index = 0;
		for(Perfil s : seguidores ){
			array[index++] = s;
		}
		return array;
	}
	
	public Tweet[] getTimeline(){
		Tweet array[] = new Tweet[this.timeline.size()];
		int index = 0;
		for(Tweet t : timeline ){
			array[index++] = t;
		
		}
		return array;
	}
	
	
	public void setAtivo(boolean valor){
		this.ativo = valor;
	}
	
	public boolean isAtivo(){
		return this.ativo;
	}
	
	public int tamanho(){
		return seguidores.size();
	}
	
	public Vector<Tweet> ler(String diretorio){
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("Tweets", Vector.class);
		xStream.alias("Tweet", Tweet.class);
		//xStream.alias("UsuarioPJ", PessoaJuridica.class);
		//String path = new File(diretorio).getCanonicalPath();
		//xStream.processAnnotations(PessoaFisica.class);

		try {
			String path = new File(diretorio).getCanonicalPath();
			BufferedReader input = new BufferedReader(new FileReader(path));
			Vector<Tweet> vpf = (Vector<Tweet>) xStream.fromXML(input);
			input.close();
			return vpf;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
