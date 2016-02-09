package main.br.com.solid.model.projeto.calculadoradeestimativa;

import java.util.function.ToLongFunction;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public interface RegraDeCalculoDeEstimativaDeProjeto {
	
	ToLongFunction<? super Tarefa> regraDeCalculo();

}
