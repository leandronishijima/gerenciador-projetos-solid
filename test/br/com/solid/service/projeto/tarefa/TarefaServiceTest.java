package br.com.solid.service.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.OS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.dao.projeto.ProjetoDao;
import main.br.com.solid.dao.projeto.ProjetoDaoDatabaseMock;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.Tarefa;

import org.junit.Test;

public class TarefaServiceTest {

	@Test
	public void adiciona_tarefa_em_projeto() {
		ProjetoDao projetoDao = new ProjetoDaoDatabaseMock();
		Projeto projeto = new Projeto("Cliente Novo", "Prospect");
		
		projetoDao.saveOrUpdate(projeto);
		
		Tarefa os = criaTarefaDesenvolvimento();
		projeto.adicionaTarefa(os);
		
		projetoDao.saveOrUpdate(projeto);
		
		Projeto projetoPesquisado = projetoDao.pesquisaPorId(projeto.getId());

		assertThat(projetoPesquisado.getTarefas(), hasSize(1));
		assertThat(projetoPesquisado.getTarefas().get(0), equalTo(os));
	}
	
	private Tarefa criaTarefaDesenvolvimento() {
		Tarefa tarefa = new Tarefa("OS-01", "Desenvolvimento de nova funcionalidade", 1, LocalDate.of(2016, JANUARY, 30), OS);
		return tarefa;
	}

}
