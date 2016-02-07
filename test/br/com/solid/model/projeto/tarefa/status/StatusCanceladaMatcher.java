package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusCancelada;

public class StatusCanceladaMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Cancelada'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusCancelada;
	}

}
