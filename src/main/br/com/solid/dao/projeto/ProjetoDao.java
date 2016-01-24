package main.br.com.solid.dao.projeto;

import java.util.List;

import main.br.com.solid.model.projeto.Projeto;

public interface ProjetoDao {

	void saveOrUpdate(Projeto projeto);

	Projeto pesquisaPorId(Long id);

	List<Projeto> listAll();

	void exclui(Projeto projet);

}