package main.br.com.solid.service.usuario;

import java.util.List;

import main.br.com.solid.dao.usuario.UsuarioDao;
import main.br.com.solid.model.usuario.Usuario;

public class UsuarioService {

	private UsuarioDao dao;
	
	public UsuarioService() {
		dao = new UsuarioDao();
	}

	public boolean saveOrUpdate(Usuario usr) {
		dao.saveOrUpdate(usr);
		
		return true;
	}

	public Usuario pesquisaUsuario(Long id) {
		return dao.pesquisaPorId(id);
	}

	public List<Usuario> listaTodos() {
		return dao.listAll();
	}
	
}
