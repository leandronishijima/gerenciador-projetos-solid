package main.br.com.solid.model.projeto.tarefa.logwork.tempodecorrido;

import java.util.List;

import main.br.com.solid.model.projeto.tarefa.logwork.LogWork;

public class CalculadoraDeTempoDecorrido {
	
	private List<LogWork> logs;
	private RegraDeCalculoDeTempoDecorrido regra;

	private CalculadoraDeTempoDecorrido(List<LogWork> logs, RegraDeCalculoDeTempoDecorrido regra) {
		this.logs = logs;
		this.regra = regra;
	}
	
	public static long calculaTempoDecorrido(List<LogWork> logs, RegraDeCalculoDeTempoDecorrido regra) {
		return new CalculadoraDeTempoDecorrido(logs, regra).calculaTempo();
	}
	
	private long calculaTempo() {
		return regra.calcula(logs);
	}

}
