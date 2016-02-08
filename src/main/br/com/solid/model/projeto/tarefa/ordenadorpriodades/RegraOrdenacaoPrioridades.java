package main.br.com.solid.model.projeto.tarefa.ordenadorpriodades;

import java.util.Comparator;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public interface RegraOrdenacaoPrioridades {

	Comparator<? super Tarefa> getComparador();

}
