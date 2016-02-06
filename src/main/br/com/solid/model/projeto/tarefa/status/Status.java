package main.br.com.solid.model.projeto.tarefa.status;

import java.util.List;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public abstract class Status {
	
	abstract List<Status> preCondicoes();
	
	abstract String getDescricao();
	
	abstract void executaAcao(Tarefa tarefaAlvo);
	
	@Override
	public boolean equals(Object obj) {
		Status other = (Status) obj;
		return this.getDescricao().equals(other.getDescricao());
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}

}
