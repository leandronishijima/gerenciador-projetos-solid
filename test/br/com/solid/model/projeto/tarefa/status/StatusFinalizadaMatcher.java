package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusFinalizada;

public class StatusFinalizadaMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Finalizada'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusFinalizada;
	}

}
