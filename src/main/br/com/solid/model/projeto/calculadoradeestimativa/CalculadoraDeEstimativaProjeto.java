package main.br.com.solid.model.projeto.calculadoradeestimativa;

import main.br.com.solid.model.projeto.Projeto;


public class CalculadoraDeEstimativaProjeto {

	private Projeto projeto;
	private RegraDeCalculoDeEstimativaDeProjeto regra;

	public CalculadoraDeEstimativaProjeto(Projeto projeto, RegraDeCalculoDeEstimativaDeProjeto regra) {
		this.projeto = projeto;
		this.regra = regra;
	}

	public Long calculaEstimativaEmDias() {
		return projeto.getTarefas()
				.stream()
				.mapToLong(regra.regraDeCalculo())
				.sum();
	}

}
