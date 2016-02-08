package main.br.com.solid.model.projeto.tarefa.ordenadorpriodades;

import java.util.Comparator;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class RegraDeOrdenacaoPrioridadeOnly implements RegraOrdenacaoPrioridades {

	@Override
	public Comparator<? super Tarefa> getComparador() {
		return (t1, t2) -> t1.getDetalhes().getPrioridade().compareTo(t2.getDetalhes().getPrioridade());
	}

}
