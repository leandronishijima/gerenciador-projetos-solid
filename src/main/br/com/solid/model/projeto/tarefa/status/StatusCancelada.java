package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.time.LocalDateTime;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusCancelada extends Status {

	private String motivoCAncelamento;
	
	public static StatusCancelada instancia() {
		return new StatusCancelada();
	}

	private StatusCancelada(String motivoCancelamento) {
		this.motivoCAncelamento = motivoCancelamento;
	}
	
	private StatusCancelada() {}

	public static StatusCancelada motivoCancelamento(String motivoCancelamento) {
		return new StatusCancelada(motivoCancelamento);
	}

	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(StatusDesenvolvendo.instancia()));
	}

	@Override
	String getDescricao() {
		return "'Cancelada'";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		tarefaAlvo.setMotivoCancelamento(motivoCAncelamento);
		tarefaAlvo.setDataFinalizacao(LocalDateTime.now());
	}

}
