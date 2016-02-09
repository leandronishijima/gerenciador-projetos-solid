package main.br.com.solid.dao.projeto;

import static main.br.com.solid.dao.Database.geraIdUnico;

import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.dao.Database;
import main.br.com.solid.model.projeto.Projeto;

public class ProjetoDaoDatabaseMock implements ProjetoDao {
	
	private Database dataBaseProjetos;
	
	public ProjetoDaoDatabaseMock() {
		dataBaseProjetos = Database.getInstance();
	}

	@Override
	public void saveOrUpdate(Projeto projeto) {
		if(projeto.getId() == null)
			projeto.setId(geraIdUnico(projeto));
		
		dataBaseProjetos.getProjetos().put(projeto.getId(), projeto);
	}

	@Override
	public Projeto pesquisaPorId(Long id) {
		return dataBaseProjetos.getProjetos().get(id);
	}

	@Override
	public List<Projeto> listAll() {
		return new ArrayList<Projeto>(dataBaseProjetos.getProjetos().values());
	}
	
	@Override
	public void exclui(Projeto projeto) {
		Projeto projetoPesquisado = pesquisaPorId(projeto.getId());
		
		if(projetoPesquisado == null)
			throw new RuntimeException("Projeto não encontrado!");
		
		dataBaseProjetos.getProjetos().remove(projetoPesquisado.getId());
	}
	
}
