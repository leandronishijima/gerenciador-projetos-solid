package br.com.solid.service.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.OS;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.dao.projeto.ProjetoDao;
import main.br.com.solid.dao.projeto.ProjetoDaoDatabaseMock;
import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;

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
		Tarefa tarefa = TarefaBuilder.builder()
				.titulo("OS-01")
				.comDescricao("Desenvolvimento de nova funcionalidade")
				.comEstimativa(UM_DIA)
				.comPrevisaoDeInicioEm(LocalDate.of(2016, JANUARY, 30))
				.comCategoria(OS).build();
		return tarefa;
	}

}
