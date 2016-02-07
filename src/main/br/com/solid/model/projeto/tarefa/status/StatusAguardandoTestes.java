package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusAguardandoTestes extends Status {
	
	private StatusAguardandoTestes() {}
	
	public static StatusAguardandoTestes instancia() {
		return new StatusAguardandoTestes();
	}

	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(StatusDesenvolvendo.instancia()));
	}

	@Override
	String getDescricao() {
		return "'Aguardando Testes'";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		tarefaAlvo.setFimDesenvolvimento(LocalDate.now());
	}

}
