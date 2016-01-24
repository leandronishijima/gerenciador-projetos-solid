package main.br.com.solid.service.projeto;

import java.util.List;

import main.br.com.solid.dao.projeto.ProjetoDao;
import main.br.com.solid.model.projeto.Projeto;

public class ProjetoService {
	
	private ProjetoDao dao;
	
	public ProjetoService(ProjetoDao dao) {
		this.dao = dao;
	}

	public boolean saveOrUpdate(Projeto projeto) {
		dao.saveOrUpdate(projeto);
		
		return true;
	}

	public List<Projeto> listAll() {
		return dao.listAll();
	}

	public Projeto pesquisaProjeto(Long id) {
		return dao.pesquisaPorId(id);
	}

	public void exlcui(Projeto projeto) {
		dao.exclui(projeto);
	}

}
