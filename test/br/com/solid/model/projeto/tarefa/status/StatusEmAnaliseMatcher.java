package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusEmAnalise;

public class StatusEmAnaliseMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Em Análise'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusEmAnalise;
	}
	
	

}
