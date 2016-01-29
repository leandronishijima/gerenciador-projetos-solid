package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.dao.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.dao.projeto.tarefa.StatusTarefa.EM_ANALISE;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.dao.projeto.tarefa.Tarefa;

import org.junit.Test;

public class TarefaTest {

	@Test
	public void criacao_tarefa_happy_day() {
		LocalDate dataCriacao = LocalDate.of(2015, JANUARY, 29);
		Tarefa tarefa = new Tarefa(1, dataCriacao, BUG);
		
		assertThat(tarefa.getStatus(), equalTo(EM_ANALISE));
		assertThat(tarefa.getCategoria(), equalTo(BUG));
		assertThat(tarefa.getDataCriacao(), equalTo(LocalDate.of(2015, JANUARY, 29)));
	}

}
