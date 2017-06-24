package br.ufc.dc.tpi.mytwitter.perfil;
import java.util.Vector;


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
}
