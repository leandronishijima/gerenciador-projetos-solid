package main.br.com.solid.service.projeto.tarefa.calculadoraestimativa;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class CalculadoraDeEstimativa {
	
	private Tarefa tarefa;

	public CalculadoraDeEstimativa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void calculaFimPrevisto() {
		LocalDate inicioPrevisto = tarefa.getInicioPrevisto();
		tarefa.setFimPrevisto(inicioPrevisto.plusDays(tarefa.getEstimativa().getQtdDias()));
	}
	

}
