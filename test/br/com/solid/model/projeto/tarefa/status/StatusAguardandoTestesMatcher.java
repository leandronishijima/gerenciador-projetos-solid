package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusAguardandoTestes;

public class StatusAguardandoTestesMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Aguardando testes'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusAguardandoTestes;
	}

}
