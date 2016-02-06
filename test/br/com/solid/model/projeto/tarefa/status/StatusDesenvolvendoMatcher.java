package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.status.StatusDesenvolvendo;

public class StatusDesenvolvendoMatcher extends StatusMatcher {

	@Override
	protected String getDescricaoStatus() {
		return "'Desenvolvendo'";
	}

	@Override
	protected boolean match() {
		return getStatus() instanceof StatusDesenvolvendo;
	}

}
