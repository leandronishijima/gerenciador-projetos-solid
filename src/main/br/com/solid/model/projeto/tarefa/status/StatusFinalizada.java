package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.time.LocalDateTime;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusFinalizada extends Status {
	
	private StatusFinalizada() {}
	
	public static StatusFinalizada instancia() {
		return new StatusFinalizada();
	}

	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(StatusEmTestes.instancia()));
	}

	@Override
	String getDescricao() {
		return "'Finalizada'";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		tarefaAlvo.setDataFinalizacao(LocalDateTime.now());
	}

}
