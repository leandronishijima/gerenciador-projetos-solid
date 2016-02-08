package main.br.com.solid.model.projeto.tarefa.ordenadorpriodades;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class OrdenadorDePrioridades {

	private List<Tarefa> tarefas;
	private RegraOrdenacaoPrioridades regra;

	private OrdenadorDePrioridades(List<Tarefa> tarefas, RegraOrdenacaoPrioridades regra) {
		this.tarefas = new ArrayList<Tarefa>(tarefas);
		this.regra = regra;
	}
	
	public static List<Tarefa> getTarefasOrdenadas(List<Tarefa> tarefas, RegraOrdenacaoPrioridades regra) {
		OrdenadorDePrioridades ordenador = new OrdenadorDePrioridades(tarefas, regra);
		ordenador.sort();
		
		return ordenador.getListaOrdenada();
	}

	private void sort() {
		tarefas.sort(regra.getComparador());
	}

	private List<Tarefa> getListaOrdenada() { 
		return unmodifiableList(tarefas);
	}

}
