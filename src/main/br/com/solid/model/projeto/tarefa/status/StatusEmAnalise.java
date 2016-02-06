package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Collections.unmodifiableList;

import java.util.Collections;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusEmAnalise extends Status {
	
	private StatusEmAnalise() {}
	
	public static StatusEmAnalise instancia() {
		return new StatusEmAnalise();
	}

	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(Collections.emptyList());
	}

	@Override
	String getDescricao() {
		return "Em Análise";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {}

}
