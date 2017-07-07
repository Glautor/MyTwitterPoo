package br.ufc.dc.tpi.mytwitter.twitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaFisica;
import br.ufc.dc.tpi.mytwitter.perfil.PessoaJuridica;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.IRepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.MFPException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.SIException;
import javafx.animation.Timeline;

import java.util.ArrayList;

@XStreamAlias(value = "MyTwitter")
public class MyTwitter implements ITwitter {
	private IRepositorioUsuario repositorio;
	Vector<Tweet> vtw;
	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;
		this.vtw = new Vector<Tweet>();
		this.vtw = ler("src/br/ufc/dc/tpi/mytwitter/data/tweets/Tweets.xml");
	}

	@Override
	public void criarPerfil(Perfil usuario) throws PEException, UJCException {
	
			if (repositorio.buscar(usuario.getUsuario()) == null) {
				repositorio.cadastrar(usuario);
			} else {
				throw new PEException(usuario.getUsuario());
			}	
	}

	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException {
		try {

			Perfil p = repositorio.buscar(usuario);
			if (p != null && p.isAtivo() == true) {
				p.setAtivo(false);
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}

	}

	@Override
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException {
		Tweet t = new Tweet();
		Perfil p = repositorio.buscar(usuario);
		Vector<Tweet> pp = new Vector<Tweet>();
		try {
			if (p != null && p.isAtivo() == true) {
				if (mensagem.length() <= 140) {
					t.setUsuario(usuario);
					t.setMensagem(mensagem);
					//p.addTweet(t);
					this.vtw.add(t);
					for (Tweet tt : vtw) {
						pp.add(tt);
					}
					for (Perfil pe : p.getSeguidores()) {
						if (pe.isAtivo() == true) {
							pe.addTweet(t);
						}
					}
				} else {
					throw new MFPException();
				}
			} else {
				throw new PIException(usuario);
			}
			gravar("src/br/ufc/dc/tpi/mytwitter/data/tweets/Tweets.xml", pp);
		} catch (PIException e) {
			e.printStackTrace();
		} catch (MFPException e) {
			e.printStackTrace();
		}

	}

	@Override

	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Tweet> tws = new Vector<Tweet>();
		try {
			if (p != null && p.isAtivo() == true) {
				for(Tweet tt : p.getTimeline()){
					if(tt.getUsuario() == usuario){
						p.addTweet(tt);
						tws.add(tt);
					}
				}
				//for (Tweet ta : p.getTimeline()) {
					//tws.add(ta);
					//System.out.println(ta.getMensagem());
				//}
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
			gravar("src/br/ufc/dc/tpi/mytwitter/data/timelines/timeline"+ "-" + usuario + ".xml", tws);
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return tws;
	}

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		// System.out.println(p.getUsuario());
		Vector<Tweet> tw = new Vector<Tweet>();
		try {
			if (p != null && p.isAtivo() == true) {
				for (Tweet ta : vtw) {
					if (ta.getUsuario().equals(usuario)) {
						tw.add(ta);
						// System.out.println(ta.getMensagem());
					}

				}
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}

		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return tw;
	}

	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		Perfil p = repositorio.buscar(seguidor);
		Perfil pp = repositorio.buscar(seguido);
		try {
			if (seguido == seguidor) {
				throw new SIException();
			}

			if (p == null || pp == null) {
				throw new PIException(seguido);
			}
			if (p != null && p.isAtivo() == false || pp != null && p.isAtivo() == false) {
				throw new PDException(seguido);
			}
			if (p != null && p.isAtivo() == true && pp != null && pp.isAtivo() == true) {
				pp.addSeguidor(p);
				p.addSeguido(pp);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		} catch (SIException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		int inativos = 0;
		try {
			if (p != null && p.isAtivo() == true) {
				for (Perfil pp : p.getSeguidores()) {
					if (pp.isAtivo() == false) {
						inativos++;
					}
				}
				return p.getSeguidores().length - inativos;
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return 0;
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Perfil> vp = new Vector<Perfil>();
		Vector<String> vst = new Vector<String>();
		vst = ler2("src/br/ufc/dc/tpi/mytwitter/data/seguidores/seguidores-"+ usuario + ".xml");
		try {
			if (p != null && p.isAtivo() == true) {
				for (Perfil pp : p.getSeguidores()) {
					if (pp.isAtivo() == true) {
						vp.add(pp);
						vst.add(pp.getUsuario());
					}
				}
			}
			
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
			gravar2("src/br/ufc/dc/tpi/mytwitter/data/seguidores/seguidores"+"-"+usuario+".xml", vst);
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return vp;
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Perfil> vp = new Vector<Perfil>();
		Vector<String> vst = new Vector<String>();
		try {
			if (p != null && p.isAtivo() == true) {
				for (Perfil pp : p.getSeguidos()) {
					if (pp.isAtivo() == true) {
						vp.add(pp);
						vst.add(pp.getUsuario());
					}
				}
			}
			if (p == null) {
				throw new PIException(usuario);
			} else if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
			gravar2("src/br/ufc/dc/tpi/mytwitter/data/seguidos/seguidos"+"-"+usuario+".xml", vst);
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return vp;
	}

	public void gravar(String diretorio, Vector<Tweet> p) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("Tweets", Vector.class);
		stream.alias("Tweet", Tweet.class);
		stream.autodetectAnnotations(true);

		try {
			String path = new File(diretorio).getCanonicalPath();
			File a = new File(path);
			if (!a.exists())
				a.createNewFile();

			PrintStream gravar = new PrintStream(a);
			gravar.println(stream.toXML(p));
			gravar.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void gravar2(String diretorio, Vector<String> p) {
		XStream stream = new XStream(new DomDriver());
		stream.alias("Usuarios", Vector.class);
		stream.alias("UsuarioPF", PessoaFisica.class);
		
		stream.autodetectAnnotations(true);

		try {
			String path = new File(diretorio).getCanonicalPath();
			File a = new File(path);
			if (!a.exists())
				a.createNewFile();

			PrintStream gravar = new PrintStream(a);
			gravar.println(stream.toXML(p));
			gravar.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<Tweet> ler(String diretorio) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("Tweets", Vector.class);
		xStream.alias("Tweet", Tweet.class);
		// String path = new File(diretorio).getCanonicalPath();
		// xStream.processAnnotations(PessoaFisica.class);

		try {
			String path = new File(diretorio).getCanonicalPath();
			BufferedReader input = new BufferedReader(new FileReader(path));
			Vector<Tweet> vpf = (Vector<Tweet>) xStream.fromXML(input);
			input.close();
			return vpf;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public Vector<String> ler2(String diretorio) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("Usuarios", Vector.class);
		//xStream.alias("Tweet", Tweet.class);
		// String path = new File(diretorio).getCanonicalPath();
		// xStream.processAnnotations(PessoaFisica.class);

		try {
			String path = new File(diretorio).getCanonicalPath();
			BufferedReader input = new BufferedReader(new FileReader(path));
			Vector<String> vpf = (Vector<String>) xStream.fromXML(input);
			input.close();
			return vpf;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
