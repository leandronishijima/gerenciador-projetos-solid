package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusADesenvolver;

public class StatusADesenvolverMatcher extends StatusMatcher {
	
	@Override
	protected String getDescricaoStatus() {
		return "'A Desenvolver'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusADesenvolver;
	}
	
}
