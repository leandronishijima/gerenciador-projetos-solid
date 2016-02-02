package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static main.br.com.solid.model.projeto.tarefa.Estimativa.UM_DIA;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.TarefaBuilder;
import main.br.com.solid.service.projeto.tarefa.calculadoraestimativa.CalculadoraDeEstimativa;

import org.junit.Test;

public class CalculadoraDeEstimativaTest {

	@Test
	public void testa_calculo_de_data_fim_prevista() {
		Tarefa tarefa = criaTarefaBugPadrao();

		assertThat(tarefa.getFimPrevisto(), nullValue());
		assertThat(tarefa.getInicioPrevisto().toString(), equalTo("2016-01-29"));

		CalculadoraDeEstimativa calculadora = new CalculadoraDeEstimativa(
				tarefa);
		calculadora.calculaFimPrevisto();

		assertThat(tarefa.getFimPrevisto().toString(), equalTo("2016-01-30"));
	}

	private Tarefa criaTarefaBugPadrao() {
		Tarefa tarefa = TarefaBuilder.builder()
				.titulo("Bug!")
				.comDescricao("Bug a ser corrigido!")
				.comEstimativa(UM_DIA)
				.comPrevisaoDeInicioEm(LocalDate.of(2016, JANUARY, 29))
				.comCategoria(BUG).build();
		return tarefa;
	}

}
