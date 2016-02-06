package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Impedimento;
import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusImpedida extends Status {
	
	private Impedimento impedimento;

	private StatusImpedida() {}
	
	private StatusImpedida(Impedimento impedimento) {
		this.impedimento = impedimento;
	}

	public static StatusImpedida instancia() {
		return new StatusImpedida();
	}
	
	public static StatusImpedida comMotivoEData(String motivo, LocalDate dataImpedimento) {
		return new StatusImpedida(new Impedimento(motivo, dataImpedimento));
	}

	@Override
	List<Status> preCondicoes() {
		return unmodifiableList(asList(StatusDesenvolvendo.instancia()));
	}

	@Override
	String getDescricao() {
		return "'Impedida'";
	}

	@Override
	void executaAcao(Tarefa tarefaAlvo) {
		tarefaAlvo.impede(impedimento);
	}

}
