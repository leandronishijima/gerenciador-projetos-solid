package br.com.solid.model.projeto.tarefa;

import static java.time.Month.JANUARY;
import static main.br.com.solid.model.projeto.tarefa.CategoriaTarefa.BUG;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.CalculadoraDeEstimativa;
import main.br.com.solid.model.projeto.tarefa.Tarefa;

import org.junit.Test;

public class CalculadoraDeEstimativaTest {

	@Test
	public void testa_calculo_de_data_fim_prevista() {
		Tarefa tarefa = criaTarefaBugPadrao();
		
		assertThat(tarefa.getFimPrevisto(), nullValue());
		assertThat(tarefa.getInicioPrevisto().toString(), equalTo("2016-01-29"));
		
		CalculadoraDeEstimativa calculadora = new CalculadoraDeEstimativa(tarefa);
		calculadora.calculaFimPrevisto();
		
		assertThat(tarefa.getFimPrevisto().toString(), equalTo("2016-01-30"));
	}

	private Tarefa criaTarefaBugPadrao() {
		Tarefa tarefa = new Tarefa("Bug!", "Bug a ser corrigido!", 1, LocalDate.of(2016, JANUARY, 29), BUG);
		return tarefa;
	}

}
