package main.br.com.solid.model.projeto.tarefa;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class OrdenadorDePrioridades {

	private List<Tarefa> tarefas;

	public OrdenadorDePrioridades(List<Tarefa> tarefas) {
		this.tarefas = new ArrayList<Tarefa>(tarefas);
	}

	public void sort() {
		tarefas.sort((t1, t2) -> t1.getDetalhes().getPrioridade().compareTo(t2.getDetalhes().getPrioridade()));
	}
	
	public List<Tarefa> getListaOrdenada() {
		return unmodifiableList(tarefas);
	}

}
