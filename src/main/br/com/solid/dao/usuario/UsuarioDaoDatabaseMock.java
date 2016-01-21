package main.br.com.solid.dao.usuario;

import static main.br.com.solid.dao.Database.geraIdUnico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.br.com.solid.dao.Database;
import main.br.com.solid.model.usuario.Usuario;

public class UsuarioDaoDatabaseMock implements UsuarioDao {
	
	private static Map<Long, Usuario> dataBaseUsers;
	
	public UsuarioDaoDatabaseMock() {
		dataBaseUsers = Database.getInstance().getUsuarios();
	}

	@Override
	public void saveOrUpdate(Usuario usr) {
		if(usr.getId() == null)
			usr.setId(geraIdUnico(usr));
		
		dataBaseUsers.put(usr.getId(), usr);
	}

	@Override
	public Usuario pesquisaPorId(Long id) {
		return dataBaseUsers.get(id);
	}

	@Override
	public List<Usuario> listAll() {
		return new ArrayList<Usuario>(dataBaseUsers.values());
	}
	
	@Override
	public void exclui(Usuario usuario) {
		dataBaseUsers.remove(usuario.getId(), usuario);
	}
	

}
