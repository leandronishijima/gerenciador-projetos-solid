package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusADesenvolver extends Status {
	
	private StatusADesenvolver() {}
	
	public static StatusADesenvolver instancia() {
		return new StatusADesenvolver();
	}
	
	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(
				StatusEmAnalise.instancia(), 
				StatusImpedida.instancia()));
	}

	@Override
	String getDescricao() {
		return "A Desenvolver";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		if(tarefaAlvo.getDetalhes().isImpedida())
			tarefaAlvo.getImpedimento().retorna();
	}

}
