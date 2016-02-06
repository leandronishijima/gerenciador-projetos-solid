package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusImpedida;

public class StatusImpedidaMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Impedida'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusImpedida;
	}

}
