package br.com.solid.model.usuario.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.solid.model.usuario.Usuario;

public class UsuarioDao {
	
	private static Map<Long, Usuario> dataBaseUsers;
	
	public UsuarioDao() {
		dataBaseUsers = new HashMap<Long, Usuario>();
	}

	public void save(Usuario usr) {
		usr.setId(geraIdUnico(usr));
		dataBaseUsers.put(usr.getId(), usr);
	}

	private Long geraIdUnico(Usuario usr) {
		return (long) (usr.hashCode() * 17);
	}

	public Usuario pesquisaPorId(Long id) {
		return dataBaseUsers.get(id);
	}

}
