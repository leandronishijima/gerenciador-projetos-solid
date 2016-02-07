package main.br.com.solid.service.projeto.tarefa.calculadoraestimativa;

import java.time.LocalDate;

import main.br.com.solid.model.projeto.tarefa.DetalhesProgressoTarefa;

public class CalculadoraDeEstimativa {
	
	private DetalhesProgressoTarefa detalhesProgressoTarefa;

	public CalculadoraDeEstimativa(DetalhesProgressoTarefa detalhesProgressoTarefa) {
		this.detalhesProgressoTarefa = detalhesProgressoTarefa;
	}
	
	public void calculaFimPrevisto() {
		LocalDate inicioPrevisto = detalhesProgressoTarefa.getInicioPrevisto();
		detalhesProgressoTarefa.setFimPrevisto(inicioPrevisto.plusDays(detalhesProgressoTarefa.getEstimativa().getQtdDias()));
	}
	

}
