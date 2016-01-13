package main.br.com.solid.dao.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.br.com.solid.model.usuario.Usuario;

public class UsuarioDao {
	
	private static Map<Long, Usuario> dataBaseUsers;
	
	public UsuarioDao() {
		dataBaseUsers = new HashMap<Long, Usuario>();
	}

	public void saveOrUpdate(Usuario usr) {
		if(usr.getId() == null)
			usr.setId(geraIdUnico(usr));
		
		dataBaseUsers.put(usr.getId(), usr);
	}

	public Usuario pesquisaPorId(Long id) {
		return dataBaseUsers.get(id);
	}

	public List<Usuario> listAll() {
		return new ArrayList<Usuario>(dataBaseUsers.values());
	}
	
	private Long geraIdUnico(Usuario usr) {
		return (long) (usr.hashCode() * 17);
	}

	public void exclui(Usuario usuario) {
		dataBaseUsers.remove(usuario.getId(), usuario);
	}

}
