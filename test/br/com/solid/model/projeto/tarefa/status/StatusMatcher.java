package br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.Tarefa;
import main.br.com.solid.model.projeto.tarefa.status.Status;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public abstract class StatusMatcher extends TypeSafeMatcher<Tarefa> {
	
	private Tarefa tarefa;

	@Override
	public void describeTo(Description desc) {
		desc.appendText("tarefa deveria estar no status " + getDescricaoStatus());
	}

	protected abstract String getDescricaoStatus();

	@Override
	protected boolean matchesSafely(Tarefa tarefa) {
		this.tarefa = tarefa;
		return match();
	}

	protected abstract boolean match();
	
	protected Status getStatus() {
		return tarefa.getDetalhes().getStatus();
	}

}
