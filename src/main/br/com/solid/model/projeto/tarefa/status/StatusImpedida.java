package main.br.com.solid.model.projeto.tarefa.status;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.time.LocalDate;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Impedimento;
import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class StatusImpedida extends Status {
	
	private String motivo;
	private LocalDate dataImpedimento;

	private StatusImpedida() {}
	
	private StatusImpedida(String motivo, LocalDate dataImpedimento) {
		this.motivo = motivo;
		this.dataImpedimento = dataImpedimento;
	}

	public static StatusImpedida instancia() {
		return new StatusImpedida();
	}
	
	public static StatusImpedida comMotivoEData(String motivo, LocalDate dataImpedimento) {
		return new StatusImpedida(motivo, dataImpedimento);
	}
	
	@Override
	public boolean isStatusImpedida() {
		return true;
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
		tarefaAlvo.impede(new Impedimento(motivo, dataImpedimento));
	}

}
