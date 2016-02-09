package main.br.com.solid.model.projeto.calculadoradeestimativa;

import java.util.function.ToLongFunction;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class RegraDeCalculoDeEstimativaDeProjetoSimples implements RegraDeCalculoDeEstimativaDeProjeto {

	@Override
	public ToLongFunction<? super Tarefa> regraDeCalculo() {
		return tarefa -> tarefa.getDetalhesProgressoTarefa().getEstimativa().getQtdDias();
	}

}
