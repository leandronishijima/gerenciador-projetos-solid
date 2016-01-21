package main.br.com.solid.dao.projeto;

import static main.br.com.solid.dao.Database.geraIdUnico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.br.com.solid.dao.Database;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.usuario.Usuario;

public class ProjetoDao {
	
	private static Map<Long, Projeto> dataBaseProjetos;
	
	public ProjetoDao() {
		dataBaseProjetos = Database.getInstance().getProjetos();
	}

	public void saveOrUpdate(Projeto projeto) {
		projeto.setId(geraIdUnico(projeto));
		dataBaseProjetos.put(projeto.getId(), projeto);
	}

	public Projeto pesquisaPorId(Long id) {
		return dataBaseProjetos.get(id);
	}

	public List<Projeto> listAll() {
		return new ArrayList<Projeto>(dataBaseProjetos.values());
	}
	
	public void exclui(Usuario usuario) {
		dataBaseProjetos.remove(usuario.getId(), usuario);
	}
	
}
