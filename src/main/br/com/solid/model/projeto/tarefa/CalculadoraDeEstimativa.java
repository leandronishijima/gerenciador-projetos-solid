package main.br.com.solid.model.projeto.tarefa;

import java.time.LocalDate;

public class CalculadoraDeEstimativa {
	
	private Tarefa tarefa;

	public CalculadoraDeEstimativa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void calculaFimPrevisto() {
		LocalDate inicioPrevisto = tarefa.getInicioPrevisto();
		tarefa.setFimPrevisto(inicioPrevisto.plusDays(tarefa.getEstimativa()));
	}
	

}
