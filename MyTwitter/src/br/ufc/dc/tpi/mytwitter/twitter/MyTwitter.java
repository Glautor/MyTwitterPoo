package br.ufc.dc.tpi.mytwitter.twitter;

import java.util.Vector;

import br.ufc.dc.tpi.mytwitter.perfil.Perfil;
import br.ufc.dc.tpi.mytwitter.perfil.Tweet;
import br.ufc.dc.tpi.mytwitter.persistencia.IRepositorioUsuario;
import br.ufc.dc.tpi.mytwitter.persistencia.exception.UJCException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.MFPException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PDException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PEException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.PIException;
import br.ufc.dc.tpi.mytwitter.twitter.exception.SIException;

public class MyTwitter implements ITwitter {
	private IRepositorioUsuario repositorio;

	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;

	}

	@Override
	public void criarPerfil(Perfil usuario) throws PEException, UJCException {
		try {
			if (repositorio.buscar(usuario.getUsuario()) == null) {
				repositorio.cadastrar(usuario);
			} else {
				throw new PEException(usuario.getUsuario());
			}
		} catch (PEException e) {
			e.printStackTrace();
		} catch (UJCException ee) {
			ee.printStackTrace();
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
		Perfil p = repositorio.buscar(usuario);
		try {
			if (p != null && p.isAtivo() == true) {
				if (mensagem.length() <= 140) {
					Tweet t = new Tweet();
					t.setUsuario(usuario);
					t.setMensagem(mensagem);
					p.addTweet(t);
					for (Perfil ps : p.getSeguidores()) {
						if (ps.isAtivo() == true) {
							ps.addTweet(t);
						}
					}
				} else {
					throw new MFPException();
				}

			} else {
				throw new PIException(usuario);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (MFPException ee) {
			ee.printStackTrace();
		}
	}

	@Override
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		try {
			if (p != null && p.isAtivo() == true) {
				for (Tweet ta : p.getTimeline()) {
					System.out.println(ta.getMensagem() + " - " + ta.getUsuario());
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
		return null;
	}

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		try {
			if (p != null && p.isAtivo() == true) {
				for (Tweet ta : p.getTimeline()) {
					if (ta.getUsuario() == p.getUsuario()) {
						System.out.println(ta.getMensagem());
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
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
