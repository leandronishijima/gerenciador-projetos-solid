package main.br.com.solid.model.projeto.tarefa.logwork.tempodecorrido;

import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.concurrent.TimeUnit.HOURS;

import java.time.temporal.ChronoUnit;
import java.util.List;

import main.br.com.solid.model.projeto.tarefa.logwork.LogWork;


public class RegraDeTempoDecorridoEmHoras extends RegraDeCalculoDeTempoDecorrido {
	
	@Override
	public long calcula(List<LogWork> logs) {
		return HOURS.toMinutes(super.calcula(logs));
	}
	
	@Override
	protected ChronoUnit getChronoUnit() {
		return MINUTES;
	}

}
