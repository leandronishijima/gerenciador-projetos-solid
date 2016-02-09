package main.br.com.solid.model.projeto.calculadoradeestimativa;

import main.br.com.solid.model.projeto.Projeto;


public class CalculadoraDeEstimativaProjeto {

	private Projeto projeto;

	public CalculadoraDeEstimativaProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Long calculaEstimativaEmDias() {
		return projeto.getTarefas().stream()
				.mapToLong(tarefa -> tarefa.getDetalhesProgressoTarefa().getEstimativa().getQtdDias())
				.sum();
	}

}
