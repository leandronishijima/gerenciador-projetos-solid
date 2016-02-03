package main.br.com.solid.model.projeto.tarefa.logwork.tempodecorrido;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.ToLongFunction;

import main.br.com.solid.model.projeto.tarefa.logwork.LogWork;

public abstract class RegraDeCalculoDeTempoDecorrido {
	
	public long calcula(List<LogWork> logs) {
		return logs.stream()
				.mapToLong(funcaoCalculoPeriodoDecorrido()).sum();
	}

	protected ToLongFunction<? super LogWork> funcaoCalculoPeriodoDecorrido() {
		return log -> log.getHoraInicio().until(log.getHoraFim(), getChronoUnit());
	}

	protected abstract ChronoUnit getChronoUnit();

}
