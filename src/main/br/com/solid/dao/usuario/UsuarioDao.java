package main.br.com.solid.dao.usuario;

import java.util.List;

import main.br.com.solid.model.usuario.Usuario;

public interface UsuarioDao {
	
	void saveOrUpdate(Usuario usr);
	
	Usuario pesquisaPorId(Long id);
	
	List<Usuario> listAll();
	
	void exclui(Usuario usuario);

}
