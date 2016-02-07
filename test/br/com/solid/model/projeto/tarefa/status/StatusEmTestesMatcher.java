package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusEmTestes;

public class StatusEmTestesMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Em Testes'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusEmTestes;
	}

}
