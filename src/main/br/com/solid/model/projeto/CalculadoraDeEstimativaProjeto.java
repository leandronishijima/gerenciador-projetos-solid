package main.br.com.solid.model.projeto;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class CalculadoraDeEstimativaProjeto {

	private Projeto projeto;

	public CalculadoraDeEstimativaProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Long calculaEstimativaEmDias() {
		long t = 0l;
		
		for (Tarefa tarefa : projeto.getTarefas())
			t += tarefa.getDetalhesProgressoTarefa().getEstimativa().getQtdDias();
		
		return t;
	}

}
