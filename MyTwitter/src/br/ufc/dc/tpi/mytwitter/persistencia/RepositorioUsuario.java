package br.ufc.dc.tpi.mytwitter.persistencia;
import java.util.Vector;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UNCException;

import java.io.*;


public class RepositorioUsuario implements IRepositorioUsuario {
	private Vector<Perfil> usuarios;
	
	public RepositorioUsuario() {
		this.usuarios = new Vector<Perfil>();
	}


	public void cadastrar(Perfil usuario) throws UJCException{
		 String pathDir = "C:/Users/dhann/Desktop";
		 File diretorio = new File(pathDir);
		 if (!diretorio.isDirectory()) {
		 diretorio.mkdir();
		 }
		 
		if (this.buscar(usuario.getUsuario()) == null) {
			this.usuarios.add(usuario);
			 try {
				 String pathArquivo = pathDir + "/" + "Usuarios.txt";
				 FileWriter arquivo = new FileWriter(pathArquivo);
				 PrintWriter gravador = new PrintWriter(arquivo);
				
				for(Perfil u: usuarios){
					gravador.println(u.getUsuario());
				}
				 gravador.close();
			 }catch (IOException ioe) {
				 ioe.printStackTrace();
			 }
		}else{
			throw new UJCException(usuario.getUsuario());
		}
		 
	}


	public Perfil buscar(String usuario) {
		for (Perfil u : usuarios) {
			if (u.getUsuario().equals(usuario)) {
				return u;
			}
		}
		return null;
	}


	public void atualizar(Perfil usuario) throws UNCException {
		 String pathDir = "C:/Users/dhann/Desktop";
		 String pathArquivo = pathDir + "/" + "Usuarios.txt";
		 
		 
		Perfil p = this.buscar(usuario.getUsuario());
			if(p != null){
				 try {
		
					 FileReader arquivo = new FileReader(pathArquivo);
					 BufferedReader leitor = new BufferedReader(arquivo);
					 String conteudo = leitor.readLine();
					 while(conteudo != null){
						 System.out.println(conteudo);
						 conteudo = leitor.readLine();						 
						 if(conteudo == usuario.getUsuario()){
							 
						 }
						
					 }
					 leitor.close();
					 usuario = p;
				
			
				 }catch (IOException ioe) {
					 ioe.printStackTrace();
				 }
				
				
			}else{
				throw new UNCException(usuario.getUsuario());
			}
	}
	
	public Perfil[] listar() {
		Perfil array[] = new Perfil[this.usuarios.size()];
		int index = 0;
		for (Perfil conta : usuarios) {
			array[index++] = conta;
		}
		return array;
	}
	
	public int tamanho(){
		return this.usuarios.size();
	}

}
