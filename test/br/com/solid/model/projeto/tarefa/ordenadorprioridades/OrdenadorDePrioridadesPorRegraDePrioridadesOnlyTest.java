package br.com.solid.model.projeto.tarefa.ordenadorprioridades;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.OS;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.BLOQUEADOR;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.CRITICO;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.MAIOR;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.MENOR;
import static main.br.com.solid.model.projeto.tarefa.Prioridade.TRIVIAL;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.List;

import main.br.com.solid.model.projeto.Projeto;
import main.br.com.solid.model.projeto.tarefa.CategoriaTarefa;
import main.br.com.solid.model.projeto.tarefa.Estimativa;
import main.br.com.solid.model.projeto.tarefa.Prioridade;
import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.model.projeto.tarefa.ordenadorpriodades.OrdenadorDePrioridades;
import main.br.com.solid.model.projeto.tarefa.ordenadorpriodades.RegraDeOrdenacaoPrioridadeOnly;

import org.junit.Test;

public class OrdenadorDePrioridadesPorRegraDePrioridadesOnlyTest {

	@Test
	public void retorna_prioridade_bloqueador_acima_das_outras() {
		Tarefa bug = criaTarefaBloqueadora();
		Tarefa os = criaTarefaMaior();
		
		Projeto projeto = new Projeto("Gerenciador de Projetos", "Novo gerenciador de projetos revolucionário!");
		adicionaTarefasAoProjeto(projeto, os, bug);
		
		assertThat(getTarefasOrdenadasPorPrioridade(projeto.getTarefas()), contains(bug, os));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void erro_ao_tentar_alterar_lista_ordenada_de_tarefas() {
		Tarefa bug = criaTarefaBloqueadora();
		Tarefa os = criaTarefaMaior();
		
		Projeto projeto = new Projeto("Gerenciador de Projetos", "Novo gerenciador de projetos revolucionário!");
		adicionaTarefasAoProjeto(projeto, os, bug);
		
		getTarefasOrdenadasPorPrioridade(projeto.getTarefas()).remove(0);
	}
	
	@Test
	public void retorna_todos_as_prioridades_ordenadas() {
		Tarefa prioridadeBloqueadora = criaTarefaBloqueadora();
		Tarefa prioridadeCritica = criaTarefaCritica();
		Tarefa prioridadeMaior = criaTarefaMaior();
		Tarefa prioridadeMenor = criaTarefaMenor();
		Tarefa prioridadeTrivial = criaTarefaTrivial();
		
		Projeto projeto = new Projeto("Gerenciador de Projetos", "Novo gerenciador de projetos revolucionário!");
		adicionaTarefasAoProjeto(projeto, prioridadeTrivial, prioridadeBloqueadora, prioridadeMenor, prioridadeCritica, prioridadeMaior);
		
		assertThat(getTarefasOrdenadasPorPrioridade(projeto.getTarefas()), contains(
				prioridadeBloqueadora, prioridadeCritica, prioridadeMaior, prioridadeMenor, prioridadeTrivial));
	}

	private Tarefa criaTarefaTrivial() {
		return criaTarefa("OS!", "OS a ser implementada!", UM_DIA, LocalDate.of(2016, JANUARY, 30), OS, TRIVIAL);
	}

	private Tarefa criaTarefaMenor() {
		return criaTarefa("OS!", "OS a ser implementada!", UM_DIA, LocalDate.of(2016, JANUARY, 30), OS, MENOR);
	}

	private Tarefa criaTarefaMaior() {
		return criaTarefa("OS!", "OS a ser implementada!", UM_DIA, LocalDate.of(2016, JANUARY, 30), OS, MAIOR);
	}

	private Tarefa criaTarefaCritica() {
		return criaTarefa("OS!", "OS a ser implementada!", UM_DIA, LocalDate.of(2016, JANUARY, 30), OS, CRITICO);
	}

	private Tarefa criaTarefaBloqueadora() {
		return criaTarefa("Bug!", "Bug a ser corrigido!", UM_DIA, LocalDate.of(2016, JANUARY, 29), BUG, BLOQUEADOR);
	}
	
	private void adicionaTarefasAoProjeto(Projeto projeto, Tarefa... tarefas) {
		for (Tarefa tarefa : tarefas)
			projeto.adicionaTarefa(tarefa);
	}
	
	private List<Tarefa> getTarefasOrdenadasPorPrioridade(List<Tarefa> tarefasASerOrdenadas) {
		return OrdenadorDePrioridades.getTarefasOrdenadas(tarefasASerOrdenadas, new RegraDeOrdenacaoPrioridadeOnly());
	}
	
	private Tarefa criaTarefa(String titulo, String descricao, Estimativa estimativa, LocalDate inicioEm, CategoriaTarefa categoriaTarefa, Prioridade prioridade) {
		Tarefa tarefa = TarefaBuilder.builder()
				.titulo(titulo)
				.comDescricao(descricao)
				.comEstimativa(estimativa)
				.comPrevisaoDeInicioEm(inicioEm)
				.comCategoria(categoriaTarefa)
				.comPrioridade(prioridade).build();
		return tarefa;
	}

}
