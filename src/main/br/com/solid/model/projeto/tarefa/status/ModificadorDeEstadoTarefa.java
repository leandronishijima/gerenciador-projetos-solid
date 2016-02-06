package main.br.com.solid.model.projeto.tarefa.status;

import main.br.com.solid.model.projeto.tarefa.Tarefa;

public class ModificadorDeEstadoTarefa {

	private Tarefa tarefa;
	private Status status;

	private ModificadorDeEstadoTarefa(Tarefa tarefa, Status statusAlvo) {
		this.tarefa = tarefa;
		this.status = statusAlvo;
	}
	
	public static void alteraStatus(Tarefa tarefa, Status statusAlvo) {
		ModificadorDeEstadoTarefa modificador = new ModificadorDeEstadoTarefa(tarefa, statusAlvo);
		modificador.alteraStatus();
	}
	
	private void alteraStatus() {
		if(isStatusAlvoInvalido())
			throw new IllegalArgumentException("Status inválido!");
		
		status.executaAcao(tarefa);
		tarefa.setStatus(status);
	}

	private boolean isStatusAlvoInvalido() {
		return !status.preCondicoes().contains(tarefa.getStatus());
	}

}
