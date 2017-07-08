package br.ufc.dc.tpi.mytwitter.persistencia;

import java.util.Vector;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaJuridica;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UNCException;

import java.io.*;

public class RepositorioUsuario implements IRepositorioUsuario {
	private Vector<Perfil> usuarios;

	public RepositorioUsuario() {
		
		this.usuarios = new Vector<Perfil>();
		this.usuarios = ler("src/br/ufc/dc/tpi/mytwitter/data/usuarios/Usuarios.xml");
		
	}

	public void cadastrar(Perfil usuario) throws UJCException {
		Vector<Perfil> p = new Vector<Perfil>();
		
		try {
			if (this.buscar(usuario.getUsuario()) == null) {
				this.usuarios.add(usuario);

				for (Perfil u : usuarios) {
					p.add(u);
				}
				gravar("C:/Users/dhann/Documents/Git/MyTwitter/src/br/ufc/dc/tpi/mytwitter/data/usuarios/Usuarios.xml", p);
			} else {
				throw new UJCException(usuario.getUsuario());
			}
		} catch (UJCException e) {
			e.printStackTrace();
		} 

	}
	
	public void gravar(String diretorio,Vector<Perfil> p){
		XStream stream = new XStream(new DomDriver());
		stream.alias("Usuarios", Vector.class);
		stream.alias("UsuarioPF", PessoaFisica.class);
		stream.alias("UsuarioPJ", PessoaJuridica.class);
		stream.autodetectAnnotations(true);
		
		
		try {
		String path = new File(diretorio).getCanonicalPath();
		File a = new File(path);
			if(!a.exists()) a.createNewFile();
			
			PrintStream gravar = new PrintStream(a);
			gravar.println(stream.toXML(p));
			gravar.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Perfil> ler(String diretorio){
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("Usuarios", Vector.class);
		xStream.alias("UsuarioPF", PessoaFisica.class);
		xStream.alias("UsuarioPJ", PessoaJuridica.class);
		//String path = new File(diretorio).getCanonicalPath();
		//xStream.processAnnotations(PessoaFisica.class);

		try {
			String path = new File(diretorio).getCanonicalPath();
			BufferedReader input = new BufferedReader(new FileReader(path));
			Vector<Perfil> vpf = (Vector<Perfil>) xStream.fromXML(input);
			input.close();
			return vpf;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
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
		Vector<Perfil> pp = new Vector<Perfil>();
		
		Perfil p = this.buscar(usuario.getUsuario());
		if (p != null) {
			this.usuarios.add(usuario);
			for (Perfil u : usuarios) {
				pp.add(u);
			}
			gravar("C:/Users/dhann/Documents/Git/MyTwitter/src/br/ufc/dc/tpi/mytwitter/data/usuarios/Usuarios.xml", pp);

		} else {
			throw new UNCException(usuario.getUsuario());
		}
	}

	

}
